INSERT INTO roles VALUES (null, 'ROLE_USER');
INSERT INTO roles VALUES (null, 'ROLE_ADMIN');

INSERT INTO categories VALUES (null, 'hitch-hiking'), (null, 'bus');

Show tables;
select * from excursions_members;
select * from categories;
select * from excursions_categories;
select * from excursions_countries;
select * from excursions;
# select * from comments;
select * from countries;
select * from users;
# select * from user_roles;
select * from roles;



# create database join_the_footprints character set UTF8mb4 collate utf8mb4_bin;
# create database join_the_footprints COLLATE utf8mb4_unicode_ci;
# use join_the_footprints;
# drop database join_the_footprints;

UPDATE countries set name = UPPER(name);

INSERT INTO `countries` VALUES (null, 'Afghanistan');
INSERT INTO `countries` VALUES (null, 'Albania');
INSERT INTO `countries` VALUES (null, 'Algeria');
INSERT INTO `countries` VALUES (null, 'American Samoa');
INSERT INTO `countries` VALUES (null, 'Andorra');
INSERT INTO `countries` VALUES (null, 'Angola');
INSERT INTO `countries` VALUES (null, 'Anguilla');
INSERT INTO `countries` VALUES (null, 'Antarctica');
INSERT INTO `countries` VALUES (null, 'Antigua and Barbuda');
INSERT INTO `countries` VALUES (null, 'Argentina');
INSERT INTO `countries` VALUES (null, 'Armenia');
INSERT INTO `countries` VALUES (null, 'Aruba');
INSERT INTO `countries` VALUES (null, 'Australia');
INSERT INTO `countries` VALUES (null, 'Austria');
INSERT INTO `countries` VALUES (null, 'Azerbaijan');
INSERT INTO `countries` VALUES (null, 'Bahamas');
INSERT INTO `countries` VALUES (null, 'Bahrain');
INSERT INTO `countries` VALUES (null, 'Bangladesh');
INSERT INTO `countries` VALUES (null, 'Barbados');
INSERT INTO `countries` VALUES (null, 'Belarus');
INSERT INTO `countries` VALUES (null, 'Belgium');
INSERT INTO `countries` VALUES (null, 'Belize');
INSERT INTO `countries` VALUES (null, 'Benin');
INSERT INTO `countries` VALUES (null, 'Bermuda');
INSERT INTO `countries` VALUES (null, 'Bhutan');
INSERT INTO `countries` VALUES (null, 'Bolivia');
INSERT INTO `countries` VALUES (null, 'Bosnia and Herzegovina');
INSERT INTO `countries` VALUES (null, 'Botswana');
INSERT INTO `countries` VALUES (null, 'Bouvet Island');
INSERT INTO `countries` VALUES (null, 'Brazil');
INSERT INTO `countries` VALUES (null, 'British Indian Ocean Territory');
INSERT INTO `countries` VALUES (null, 'Brunei Darussalam');
INSERT INTO `countries` VALUES (null, 'Bulgaria');
INSERT INTO `countries` VALUES (null, 'Burkina Faso');
INSERT INTO `countries` VALUES (null, 'Burundi');
INSERT INTO `countries` VALUES (null, 'Cambodia');
INSERT INTO `countries` VALUES (null, 'Cameroon');
INSERT INTO `countries` VALUES (null, 'Canada');
INSERT INTO `countries` VALUES (null, 'Cape Verde');
INSERT INTO `countries` VALUES (null, 'Cayman Islands');
INSERT INTO `countries` VALUES (null, 'Central African Republic');
INSERT INTO `countries` VALUES (null, 'Chad');
INSERT INTO `countries` VALUES (null, 'Chile');
INSERT INTO `countries` VALUES (null, 'China');
INSERT INTO `countries` VALUES (null, 'Christmas Island');
INSERT INTO `countries` VALUES (null, 'Cocos (Keeling) Islands');
INSERT INTO `countries` VALUES (null, 'Colombia');
INSERT INTO `countries` VALUES (null, 'Comoros');
INSERT INTO `countries` VALUES (null, 'Democratic Republic of the Congo');
INSERT INTO `countries` VALUES (null, 'Republic of Congo');
INSERT INTO `countries` VALUES (null, 'Cook Islands');
INSERT INTO `countries` VALUES (null, 'Costa Rica');
INSERT INTO `countries` VALUES (null, 'Croatia (Hrvatska)');
INSERT INTO `countries` VALUES (null, 'Cuba');
INSERT INTO `countries` VALUES (null, 'Cyprus');
INSERT INTO `countries` VALUES (null, 'Czech Republic');
INSERT INTO `countries` VALUES (null, 'Denmark');
INSERT INTO `countries` VALUES (null, 'Djibouti');
INSERT INTO `countries` VALUES (null, 'Dominica');
INSERT INTO `countries` VALUES (null, 'Dominican Republic');
INSERT INTO `countries` VALUES (null, 'East Timor');
INSERT INTO `countries` VALUES (null, 'Ecuador');
INSERT INTO `countries` VALUES (null, 'Egypt');
INSERT INTO `countries` VALUES (null, 'El Salvador');
INSERT INTO `countries` VALUES (null, 'Equatorial Guinea');
INSERT INTO `countries` VALUES (null, 'Eritrea');
INSERT INTO `countries` VALUES (null, 'Estonia');
INSERT INTO `countries` VALUES (null, 'Ethiopia');
INSERT INTO `countries` VALUES (null, 'Falkland Islands (Malvinas)');
INSERT INTO `countries` VALUES (null, 'Faroe Islands');
INSERT INTO `countries` VALUES (null, 'Fiji');
INSERT INTO `countries` VALUES (null, 'Finland');
INSERT INTO `countries` VALUES (null, 'France');
INSERT INTO `countries` VALUES (null, 'France, Metropolitan');
INSERT INTO `countries` VALUES (null, 'French Guiana');
INSERT INTO `countries` VALUES (null, 'French Polynesia');
INSERT INTO `countries` VALUES (null, 'French Southern Territories');
INSERT INTO `countries` VALUES (null, 'Gabon');
INSERT INTO `countries` VALUES (null, 'Gambia');
INSERT INTO `countries` VALUES (null, 'Georgia');
INSERT INTO `countries` VALUES (null, 'Germany');
INSERT INTO `countries` VALUES (null, 'Ghana');
INSERT INTO `countries` VALUES (null, 'Gibraltar');
INSERT INTO `countries` VALUES (null, 'Guernsey');
INSERT INTO `countries` VALUES (null, 'Greece');
INSERT INTO `countries` VALUES (null, 'Greenland');
INSERT INTO `countries` VALUES (null, 'Grenada');
INSERT INTO `countries` VALUES (null, 'Guadeloupe');
INSERT INTO `countries` VALUES (null, 'Guam');
INSERT INTO `countries` VALUES (null, 'Guatemala');
INSERT INTO `countries` VALUES (null, 'Guinea');
INSERT INTO `countries` VALUES (null, 'Guinea-Bissau');
INSERT INTO `countries` VALUES (null, 'Guyana');
INSERT INTO `countries` VALUES (null, 'Haiti');
INSERT INTO `countries` VALUES (null, 'Heard and Mc Donald Islands');
INSERT INTO `countries` VALUES (null, 'Honduras');
INSERT INTO `countries` VALUES (null, 'Hong Kong');
INSERT INTO `countries` VALUES (null, 'Hungary');
INSERT INTO `countries` VALUES (null, 'Iceland');
INSERT INTO `countries` VALUES (null, 'India');
INSERT INTO `countries` VALUES (null, 'Isle of Man');
INSERT INTO `countries` VALUES (null, 'Indonesia');
INSERT INTO `countries` VALUES (null, 'Iran (Islamic Republic of)');
INSERT INTO `countries` VALUES (null, 'Iraq');
INSERT INTO `countries` VALUES (null, 'Ireland');
INSERT INTO `countries` VALUES (null, 'Israel');
INSERT INTO `countries` VALUES (null, 'Italy');
INSERT INTO `countries` VALUES (null, 'Ivory Coast');
INSERT INTO `countries` VALUES (null, 'Jersey');
INSERT INTO `countries` VALUES (null, 'Jamaica');
INSERT INTO `countries` VALUES (null, 'Japan');
INSERT INTO `countries` VALUES (null, 'Jordan');
INSERT INTO `countries` VALUES (null, 'Kazakhstan');
INSERT INTO `countries` VALUES (null, 'Kenya');
INSERT INTO `countries` VALUES (null, 'Kiribati');
INSERT INTO `countries` VALUES (null, 'Korea, Democratic People''s Republic of');
INSERT INTO `countries` VALUES (null, 'Korea, Republic of');
INSERT INTO `countries` VALUES (null, 'Kosovo');
INSERT INTO `countries` VALUES (null, 'Kuwait');
INSERT INTO `countries` VALUES (null, 'Kyrgyzstan');
INSERT INTO `countries` VALUES (null, 'Lao People''s Democratic Republic');
INSERT INTO `countries` VALUES (null, 'Latvia');
INSERT INTO `countries` VALUES (null, 'Lebanon');
INSERT INTO `countries` VALUES (null, 'Lesotho');
INSERT INTO `countries` VALUES (null, 'Liberia');
INSERT INTO `countries` VALUES (null, 'Libyan Arab Jamahiriya');
INSERT INTO `countries` VALUES (null, 'Liechtenstein');
INSERT INTO `countries` VALUES (null, 'Lithuania');
INSERT INTO `countries` VALUES (null, 'Luxembourg');
INSERT INTO `countries` VALUES (null, 'Macau');
INSERT INTO `countries` VALUES (null, 'North Macedonia');
INSERT INTO `countries` VALUES (null, 'Madagascar');
INSERT INTO `countries` VALUES (null, 'Malawi');
INSERT INTO `countries` VALUES (null, 'Malaysia');
INSERT INTO `countries` VALUES (null, 'Maldives');
INSERT INTO `countries` VALUES (null, 'Mali');
INSERT INTO `countries` VALUES (null, 'Malta');
INSERT INTO `countries` VALUES (null, 'Marshall Islands');
INSERT INTO `countries` VALUES (null, 'Martinique');
INSERT INTO `countries` VALUES (null, 'Mauritania');
INSERT INTO `countries` VALUES (null, 'Mauritius');
INSERT INTO `countries` VALUES (null, 'Mayotte');
INSERT INTO `countries` VALUES (null, 'Mexico');
INSERT INTO `countries` VALUES (null, 'Micronesia, Federated States of');
INSERT INTO `countries` VALUES (null, 'Moldova, Republic of');
INSERT INTO `countries` VALUES (null, 'Monaco');
INSERT INTO `countries` VALUES (null, 'Mongolia');
INSERT INTO `countries` VALUES (null, 'Montenegro');
INSERT INTO `countries` VALUES (null, 'Montserrat');
INSERT INTO `countries` VALUES (null, 'Morocco');
INSERT INTO `countries` VALUES (null, 'Mozambique');
INSERT INTO `countries` VALUES (null, 'Myanmar');
INSERT INTO `countries` VALUES (null, 'Namibia');
INSERT INTO `countries` VALUES (null, 'Nauru');
INSERT INTO `countries` VALUES (null, 'Nepal');
INSERT INTO `countries` VALUES (null, 'Netherlands');
INSERT INTO `countries` VALUES (null, 'Netherlands Antilles');
INSERT INTO `countries` VALUES (null, 'New Caledonia');
INSERT INTO `countries` VALUES (null, 'New Zealand');
INSERT INTO `countries` VALUES (null, 'Nicaragua');
INSERT INTO `countries` VALUES (null, 'Niger');
INSERT INTO `countries` VALUES (null, 'Nigeria');
INSERT INTO `countries` VALUES (null, 'Niue');
INSERT INTO `countries` VALUES (null, 'Norfolk Island');
INSERT INTO `countries` VALUES (null, 'Northern Mariana Islands');
INSERT INTO `countries` VALUES (null, 'Norway');
INSERT INTO `countries` VALUES (null, 'Oman');
INSERT INTO `countries` VALUES (null, 'Pakistan');
INSERT INTO `countries` VALUES (null, 'Palau');
INSERT INTO `countries` VALUES (null, 'Palestine');
INSERT INTO `countries` VALUES (null, 'Panama');
INSERT INTO `countries` VALUES (null, 'Papua New Guinea');
INSERT INTO `countries` VALUES (null, 'Paraguay');
INSERT INTO `countries` VALUES (null, 'Peru');
INSERT INTO `countries` VALUES (null, 'Philippines');
INSERT INTO `countries` VALUES (null, 'Pitcairn');
INSERT INTO `countries` VALUES (null, 'Poland');
INSERT INTO `countries` VALUES (null, 'Portugal');
INSERT INTO `countries` VALUES (null, 'Puerto Rico');
INSERT INTO `countries` VALUES (null, 'Qatar');
INSERT INTO `countries` VALUES (null, 'Reunion');
INSERT INTO `countries` VALUES (null, 'Romania');
INSERT INTO `countries` VALUES (null, 'Russian Federation');
INSERT INTO `countries` VALUES (null, 'Rwanda');
INSERT INTO `countries` VALUES (null, 'Saint Kitts and Nevis');
INSERT INTO `countries` VALUES (null, 'Saint Lucia');
INSERT INTO `countries` VALUES (null, 'Saint Vincent and the Grenadines');
INSERT INTO `countries` VALUES (null, 'Samoa');
INSERT INTO `countries` VALUES (null, 'San Marino');
INSERT INTO `countries` VALUES (null, 'Sao Tome and Principe');
INSERT INTO `countries` VALUES (null, 'Saudi Arabia');
INSERT INTO `countries` VALUES (null, 'Senegal');
INSERT INTO `countries` VALUES (null, 'Serbia');
INSERT INTO `countries` VALUES (null, 'Seychelles');
INSERT INTO `countries` VALUES (null, 'Sierra Leone');
INSERT INTO `countries` VALUES (null, 'Singapore');
INSERT INTO `countries` VALUES (null, 'Slovakia');
INSERT INTO `countries` VALUES (null, 'Slovenia');
INSERT INTO `countries` VALUES (null, 'Solomon Islands');
INSERT INTO `countries` VALUES (null, 'Somalia');
INSERT INTO `countries` VALUES (null, 'South Africa');
INSERT INTO `countries` VALUES (null, 'South Georgia South Sandwich Islands');
INSERT INTO `countries` VALUES (null, 'South Sudan');
INSERT INTO `countries` VALUES (null, 'Spain');
INSERT INTO `countries` VALUES (null, 'Sri Lanka');
INSERT INTO `countries` VALUES (null, 'St. Helena');
INSERT INTO `countries` VALUES (null, 'St. Pierre and Miquelon');
INSERT INTO `countries` VALUES (null, 'Sudan');
INSERT INTO `countries` VALUES (null, 'Suriname');
INSERT INTO `countries` VALUES (null, 'Svalbard and Jan Mayen Islands');
INSERT INTO `countries` VALUES (null, 'Swaziland');
INSERT INTO `countries` VALUES (null, 'Sweden');
INSERT INTO `countries` VALUES (null, 'Switzerland');
INSERT INTO `countries` VALUES (null, 'Syrian Arab Republic');
INSERT INTO `countries` VALUES (null, 'Taiwan');
INSERT INTO `countries` VALUES (null, 'Tajikistan');
INSERT INTO `countries` VALUES (null, 'Tanzania, United Republic of');
INSERT INTO `countries` VALUES (null, 'Thailand');
INSERT INTO `countries` VALUES (null, 'Togo');
INSERT INTO `countries` VALUES (null, 'Tokelau');
INSERT INTO `countries` VALUES (null, 'Tonga');
INSERT INTO `countries` VALUES (null, 'Trinidad and Tobago');
INSERT INTO `countries` VALUES (null, 'Tunisia');
INSERT INTO `countries` VALUES (null, 'Turkey');
INSERT INTO `countries` VALUES (null, 'Turkmenistan');
INSERT INTO `countries` VALUES (null, 'Turks and Caicos Islands');
INSERT INTO `countries` VALUES (null, 'Tuvalu');
INSERT INTO `countries` VALUES (null, 'Uganda');
INSERT INTO `countries` VALUES (null, 'Ukraine');
INSERT INTO `countries` VALUES (null, 'United Arab Emirates');
INSERT INTO `countries` VALUES (null, 'United Kingdom');
INSERT INTO `countries` VALUES (null, 'United States');
INSERT INTO `countries` VALUES (null, 'United States minor outlying islands');
INSERT INTO `countries` VALUES (null, 'Uruguay');
INSERT INTO `countries` VALUES (null, 'Uzbekistan');
INSERT INTO `countries` VALUES (null, 'Vanuatu');
INSERT INTO `countries` VALUES (null, 'Vatican City State');
INSERT INTO `countries` VALUES (null, 'Venezuela');
INSERT INTO `countries` VALUES (null, 'Vietnam');
INSERT INTO `countries` VALUES (null, 'Virgin Islands (British)');
INSERT INTO `countries` VALUES (null, 'Virgin Islands (U.S.)');
INSERT INTO `countries` VALUES (null, 'Wallis and Futuna Islands');
INSERT INTO `countries` VALUES (null, 'Western Sahara');
INSERT INTO `countries` VALUES (null, 'Yemen');
INSERT INTO `countries` VALUES (null, 'Zambia');
INSERT INTO `countries` VALUES (null, 'Zimbabwe');