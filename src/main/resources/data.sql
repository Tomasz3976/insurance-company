INSERT INTO role VALUES (1, 'ROLE_USER');
INSERT INTO role VALUES (2, 'ROLE_MANAGER');
INSERT INTO role VALUES (3, 'ROLE_ADMIN');

INSERT INTO user (id, first_name, last_name, username, day_of_birth, month_of_birth, year_of_birth, email, phone, password) VALUES (1, 'Admin', 'Account', 'admin', 1, 1, 2000, 'insurance.admin@gmail.com', 123456789, '$2a$10$n1cKjKUfe4/01cc0QwgcausLQTpsQ2fXFF9DTq7G.vM4TbpMesC4C');
INSERT INTO user (id, first_name, last_name, username, day_of_birth, month_of_birth, year_of_birth, email, phone, password) VALUES (2, 'Manager', 'Account', 'manager', 1, 1, 2000, 'insurance.manager@gmail.com', 123456789, '$2a$10$JL/aK7tGn6FhE7WvVDUFiO8KyE973Sqb7XQY6WrWeH3njGwVIEEdu');
INSERT INTO user (id, first_name, last_name, username, day_of_birth, month_of_birth, year_of_birth, email, phone, password) VALUES (3, 'User', 'Account', 'user', 1, 1, 2000, 'insurance.user@gmail.com', 123456789, '$2a$10$4fv2Lu1HsV3IdwKiGIqksOVsw/ZA6Vuoq3NgFylh1AbO04Z5rQ0vm');

INSERT INTO user_role VALUES (1,1), (1,2), (1,3), (2,1), (2,2), (3,1);