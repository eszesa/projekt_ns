CREATE TABLE employees (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    id_card VARCHAR(8),
    name VARCHAR(100) NOT NULL,
    sex ENUM ('male', 'female'),
    address VARCHAR(100),
    email VARCHAR(50) NOT NULL,
    birth_date DATE, 
    birth_place VARCHAR(50),
    phone VARCHAR(11), 
    status ENUM('active', 'passive') NOT NULL,
    status_type ENUM ('employee', 'subcontractor', 'student') NOT NULL,
    secondary_name VARCHAR(100),
    secondary_phone VARCHAR(11),
    task_class ENUM ('external', 'internal', 'manufacturer', 'management') NOT NULL,
    hourly_rate INT(20),
    monthly_hours INT(8) DEFAULT 160,
    pos VARCHAR(50)
);


INSERT INTO employees (name, status, status_type, task_class, email, hourly_rate) VALUES (
    'Ács Ádám', 'active', 'employee', 'internal', 'acsadam@gmail.com', '100'
);
INSERT INTO employees (name, status, status_type, task_class, email, hourly_rate) VALUES (
    'Arthur Teszt', 'active', 'employee', 'internal', 'arthurteszt@gmail.com', '100'
);
INSERT INTO employees (name, status, status_type, task_class, email, hourly_rate) VALUES (
    'Asztalos Anna', 'active', 'employee', 'internal', 'asztalosanna@gmail.com', '100'
);
INSERT INTO employees (name, status, status_type, task_class, email, hourly_rate) VALUES (
    'AATeszt Üzletkötő Pisti', 'active', 'employee', 'internal', 'pisti@gmail.com', '100'
);
INSERT INTO employees (name, status, status_type, task_class, email, hourly_rate) VALUES (
    'AATeszt ÜzletkötőFelelős', 'active', 'employee', 'internal', 'uzletkoto@gmail.com', '100'
);
INSERT INTO employees (name, status, status_type, task_class, email, hourly_rate) VALUES (
    'ATeszt Projektvezető', 'active', 'employee', 'internal', 'projektvezeto@gmail.com', '100'
);
INSERT INTO employees (name, status, status_type, task_class, email, hourly_rate) VALUES (
    'ATeszt SzakmaiFelelős', 'active', 'employee', 'internal', 'szakmaifelelos@gmail.com', '100'
);
INSERT INTO employees (name, status, status_type, task_class, email, hourly_rate) VALUES (
    'ATeszt MinőségBiztostó', 'active', 'employee', 'internal', 'minosegbizt@gmail.com', '100'
);
INSERT INTO employees (name, status, status_type, task_class, email, hourly_rate) VALUES (
    'Balog Bernát', 'active', 'employee', 'internal', 'balogbernat@gmail.com', '100'
);
INSERT INTO employees (name, status, status_type, task_class, email, hourly_rate) VALUES (
    'Csontos B. László', 'active', 'subcontractor', 'external', 'csontosblaszlo@gmail.com', '100'
);
INSERT INTO employees (name, status, status_type, task_class, email, hourly_rate) VALUES (
    'Deák Péter', 'active', 'subcontractor', 'external', 'deakpeter@gmail.com', '100'
);
INSERT INTO employees (name, status, status_type, task_class, email, hourly_rate) VALUES (
    'Elek Csaba József', 'active', 'employee', 'external', 'elekcsabajozsef@gmail.com', '100'
);
INSERT INTO employees (name, status, status_type, task_class, email, hourly_rate) VALUES (
    'Hakapeszi Maki	', 'passive', 'employee', 'internal', 'balogbernat@gmail.com', '100'
);
INSERT INTO employees (name, status, status_type, task_class, email, hourly_rate) VALUES (
    'Hamar József', 'passive', 'subcontractor', 'external', 'csontosblaszlo@gmail.com', '100'
);
INSERT INTO employees (name, status, status_type, task_class, email, hourly_rate) VALUES (
    'Horváth Hedvig', 'active', 'employee', 'internal', 'horvathhedvig@gmail.com', '100'
);
INSERT INTO employees (name, status, status_type, task_class, email, hourly_rate) VALUES (
    'Horváth Norbert', 'active', 'subcontractor', 'manufacturer', 'horvathnorbert@gmail.com', '100'
);
INSERT INTO employees (name, status, status_type, task_class, email, hourly_rate) VALUES (
    'Horváth Imre', 'active', 'subcontractor', 'manufacturer', 'horvathimre@gmail.com', '100'
);

CREATE TABLE companies (
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    short_name VARCHAR(30) NOT NULL,
    full_name VARCHAR(60), 
    tax_number VARCHAR(11),
    industry_classification ENUM('healthcare', 'industry', 'dealership', 'transport',  'state_administration', 'financial', 'service', 'telecommunication') NOT NULL,
    headquarters VARCHAR(50) NOT NULL,
    connection_type ENUM('unstable_cooperation', 'stable_cooperation', 'fine_cooperation', 'strategically_important', 'not_supported') DEFAULT('stable_cooperation'),
    comp_contact VARCHAR(50),
    our_contact VARCHAR(50),
    reg_number INT,
    bank_account_number VARCHAR(24),
    description TEXT(500),
    billing_name VARCHAR(30),
    billing_address VARCHAR(60)
);

ALTER TABLE companies ADD contact_id INT;

ALTER TABLE companies ADD FOREIGN KEY (contact_id) REFERENCES employees(id);

INSERT INTO companies(short_name, headquarters, industry_classification, connection_type, comp_contact, our_contact) VALUES (
    'A2Case', '1137 Budapest, Béke út 117. I/7.', 'service', 'stable_cooperation', 'Andrási Attila', 'Hódi Botond'
);
INSERT INTO companies(short_name, headquarters, industry_classification, connection_type, comp_contact, our_contact) VALUES (
    'BI-TECH', '1142 Budapest, Rohonc u. 5.', 'service', 'stable_cooperation', 'Andrási Attila', 'Bacskai János'
);
INSERT INTO companies(short_name, headquarters, industry_classification, connection_type, comp_contact, our_contact) VALUES (
    'DSK', '1036q Sofia, Moskovska str. 19.', 'financial', 'stable_cooperation', 'Genov Yurij', 'Hódi Botond'
);
INSERT INTO companies(short_name, headquarters, industry_classification, connection_type, comp_contact, our_contact) VALUES (
    'EDU', '1122 Budapest, Maros utca 19-21.', 'state_administration', 'stable_cooperation', 'Varjasy Gábor', 'Hódi Botond'
);
INSERT INTO companies(short_name, headquarters, industry_classification, connection_type, comp_contact, our_contact) VALUES (
    'ERSTE', '1138 Budapest, Népfürdő u. 24-26.', 'financial', 'stable_cooperation', 'Farkas Gabriella', 'Hódi Botond'
);
INSERT INTO companies(short_name, headquarters, industry_classification) VALUES(
    '2-Infinity', '1137 Budapest, Béke tér 117.', 'service'
);
INSERT INTO companies(short_name, headquarters, industry_classification) VALUES(
    'AAM', '1133 Budapest, Váci út 76.', 'service' 
);
INSERT INTO companies(short_name, headquarters, industry_classification) VALUES(
    'Allianz', '1087 Budapest, Könyves Kálmán krt. 48-52.', 'financial'
);
INSERT INTO companies(short_name, headquarters, industry_classification) VALUES(
    'Antark', '8151 Szabadka, Hársfa u. 3.', 'service'
);
INSERT INTO companies(short_name, headquarters, industry_classification) VALUES(
    'IBM', '1117 Budapest Neumann János u. 1.', 'service'
);
INSERT INTO companies(short_name, headquarters, industry_classification) VALUES(
    'Car-Tour', '1067 Budapest, Teréz krt. 21.', 'service'
);
INSERT INTO companies(short_name, headquarters, industry_classification) VALUES(
    'Continuo', '1142 Budapest, Sznyi út 2', 'service'
);
INSERT INTO companies(short_name, headquarters, industry_classification) VALUES(
    'ELware', '1094 Budapest, Tompa u. 26/b.', 'service'
);
INSERT INTO companies(short_name, headquarters, industry_classification) VALUES(
    'Filadelfia', '1052 Budapest, Alkotmány u. 4', 'service'
);
INSERT INTO companies(short_name, headquarters, industry_classification) VALUES(
    'HP(EDS)', '1117 Budapest, Alz u. 1. Office Garden', 'service'
);
INSERT INTO companies(short_name, headquarters, industry_classification) VALUES(
    'DOOR', '3941HS Doom, Ijskelderlann No. 1.', 'service'
);
INSERT INTO companies(short_name, headquarters, industry_classification) VALUES(
    'EXIM', '1065 Nagymező u. 46-48.', 'financial'
);