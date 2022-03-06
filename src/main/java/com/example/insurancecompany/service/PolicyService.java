package com.example.insurancecompany.service;

import com.example.insurancecompany.domain.Insurance;
import com.example.insurancecompany.domain.User;
import com.example.insurancecompany.exception.PdfCreateException;
import com.example.insurancecompany.repository.InsuranceRepository;
import com.example.insurancecompany.security.LoggedInUser;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.lowagie.text.Element.ALIGN_CENTER;
import static com.lowagie.text.FontFactory.HELVETICA;
import static com.lowagie.text.FontFactory.HELVETICA_BOLD;
import static com.lowagie.text.FontFactory.TIMES;
import static com.lowagie.text.FontFactory.TIMES_BOLD;
import static com.lowagie.text.PageSize.A4;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class PolicyService {

        private final InsuranceRepository insuranceRepository;
        private final LoggedInUser loggedInUser;

        public void createPolicy(HttpServletResponse response, Long insuranceId) {
                Insurance insurance = insuranceRepository.findById(insuranceId)
                        .orElseThrow(() -> new EntityNotFoundException("Insurance Not Found!"));
                if(!loggedInUser.getUser().getInsurances().contains(insurance)) {

                        throw new EntityNotFoundException(String.format("You Do Not Have Insurance With Id %d!", insuranceId));
                } else createPDF(response, insurance);
        }

        public void createPDF(HttpServletResponse response, Insurance insurance) {
                log.info("Policy is being created in PDF form");
                HttpServletResponse policyResponse = createResponse(response);
                Document document = new Document(A4);
                try {
                        PdfWriter.getInstance(document, policyResponse.getOutputStream());
                } catch (IOException e) {
                        throw new PdfCreateException("Failed To Create PDF File!");
                }
                User user = loggedInUser.getUser();
                document.open();
                Font company = FontFactory.getFont(TIMES_BOLD, 24);
                Font title = FontFactory.getFont(HELVETICA_BOLD, 18);
                Font description = FontFactory.getFont(HELVETICA, 11);
                Font descriptionBold = FontFactory.getFont(HELVETICA_BOLD, 12);
                Font space = FontFactory.getFont(TIMES, 18);
                Paragraph emptySpace = new Paragraph("---------------------------------------------------------------------------------------", space);
                emptySpace.setAlignment(ALIGN_CENTER);
                List<Paragraph> paragraphList = new ArrayList<>();
                paragraphList.add(new Paragraph("Insurance Company", company));
                paragraphList.add(new Paragraph(String.format("Insurance nr %d                  Type: %s", insurance.getId(), insurance.getType().toString()), title));
                paragraphList.add(new Paragraph("Insurer: Insurance Company Manchester Aspra Chomata 6-2 30200 Loutraki ", descriptionBold));
                paragraphList.add(new Paragraph(String.format("Insured: %s %s", user.getFirstName(), user.getLastName()), descriptionBold));
                paragraphList.add(new Paragraph(String.format("Insurance object details: %s", insurance.getPrintableDetails()), description));
                paragraphList.add(new Paragraph(String.format("Insurance sum: %d", insurance.getPrice()), description));
                paragraphList.add(new Paragraph(String.format("Period of insurance: from %s to %s", insurance.getStartDate(), insurance.getEndDate()), description));
                paragraphList.add(new Paragraph(String.format("The premium is payable once, by the date %s", insurance.getStartDate().plusWeeks(1)), description));
                paragraphList.add(new Paragraph("Bank account number for premium payment: 27 5800 2637 7421 1110 2398 3300"));
                paragraphList.add(new Paragraph("Policyholder's declaration:\n I declare that I have been shown and read the content" +
                        "of the power of attorney to conclude the insurance contract and confirm that before concluding the contract I have received " +
                        "the text of the General Terms and Conditions of Insurance together with additional clauses and have accepted their content.", description));
                paragraphList.add(new Paragraph("Place and date                                                                                 Signature of the policyholder", descriptionBold));
                paragraphList.get(0).setAlignment(ALIGN_CENTER);
                for (Paragraph paragraph : paragraphList) {
                        document.add(paragraph);
                        document.add(emptySpace);
                }
                document.close();
        }

        public HttpServletResponse createResponse(HttpServletResponse response) {
                response.setContentType("application/pdf");
                DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
                String currentDateTime = dateFormatter.format(new Date());
                String headerKey = "Content-Disposition";
                String headerValue = "attachment; filename=policy_" + currentDateTime + ".pdf";
                response.setHeader(headerKey, headerValue);
                return response;
        }

}
