import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

class ListCountryTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        Locale.setDefault(Locale.ENGLISH);
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }


    @Test
    void getCountryByCode(){
        assertEquals("Poland", ListCountry.getCountry("PL"));
        assertEquals("Unknown Region", ListCountry.getCountry("ZZ"));
    }


    @Test
    void isValidISOCountry(){
        assertTrue(ListCountry.isValidISOCountry("PL"));
        assertFalse(ListCountry.isValidISOCountry("ZZ"));
    }


    //this test may fail on some instances due to difference in line separators in specific environments
    @Test
    void printCountryList() {
        ListCountry.listCountry(Locale.getISOCountries());
        assertEquals("""
                    Country Code = AD, Country Name = Andorra
                    Country Code = AE, Country Name = United Arab Emirates
                    Country Code = AF, Country Name = Afghanistan
                    Country Code = AG, Country Name = Antigua & Barbuda
                    Country Code = AI, Country Name = Anguilla
                    Country Code = AL, Country Name = Albania
                    Country Code = AM, Country Name = Armenia
                    Country Code = AO, Country Name = Angola
                    Country Code = AQ, Country Name = Antarctica
                    Country Code = AR, Country Name = Argentina
                    Country Code = AS, Country Name = American Samoa
                    Country Code = AT, Country Name = Austria
                    Country Code = AU, Country Name = Australia
                    Country Code = AW, Country Name = Aruba
                    Country Code = AX, Country Name = Åland Islands
                    Country Code = AZ, Country Name = Azerbaijan
                    Country Code = BA, Country Name = Bosnia & Herzegovina
                    Country Code = BB, Country Name = Barbados
                    Country Code = BD, Country Name = Bangladesh
                    Country Code = BE, Country Name = Belgium
                    Country Code = BF, Country Name = Burkina Faso
                    Country Code = BG, Country Name = Bulgaria
                    Country Code = BH, Country Name = Bahrain
                    Country Code = BI, Country Name = Burundi
                    Country Code = BJ, Country Name = Benin
                    Country Code = BL, Country Name = St. Barthélemy
                    Country Code = BM, Country Name = Bermuda
                    Country Code = BN, Country Name = Brunei
                    Country Code = BO, Country Name = Bolivia
                    Country Code = BQ, Country Name = Caribbean Netherlands
                    Country Code = BR, Country Name = Brazil
                    Country Code = BS, Country Name = Bahamas
                    Country Code = BT, Country Name = Bhutan
                    Country Code = BV, Country Name = Bouvet Island
                    Country Code = BW, Country Name = Botswana
                    Country Code = BY, Country Name = Belarus
                    Country Code = BZ, Country Name = Belize
                    Country Code = CA, Country Name = Canada
                    Country Code = CC, Country Name = Cocos (Keeling) Islands
                    Country Code = CD, Country Name = Congo - Kinshasa
                    Country Code = CF, Country Name = Central African Republic
                    Country Code = CG, Country Name = Congo - Brazzaville
                    Country Code = CH, Country Name = Switzerland
                    Country Code = CI, Country Name = Côte d’Ivoire
                    Country Code = CK, Country Name = Cook Islands
                    Country Code = CL, Country Name = Chile
                    Country Code = CM, Country Name = Cameroon
                    Country Code = CN, Country Name = China
                    Country Code = CO, Country Name = Colombia
                    Country Code = CR, Country Name = Costa Rica
                    Country Code = CU, Country Name = Cuba
                    Country Code = CV, Country Name = Cape Verde
                    Country Code = CW, Country Name = Curaçao
                    Country Code = CX, Country Name = Christmas Island
                    Country Code = CY, Country Name = Cyprus
                    Country Code = CZ, Country Name = Czechia
                    Country Code = DE, Country Name = Germany
                    Country Code = DJ, Country Name = Djibouti
                    Country Code = DK, Country Name = Denmark
                    Country Code = DM, Country Name = Dominica
                    Country Code = DO, Country Name = Dominican Republic
                    Country Code = DZ, Country Name = Algeria
                    Country Code = EC, Country Name = Ecuador
                    Country Code = EE, Country Name = Estonia
                    Country Code = EG, Country Name = Egypt
                    Country Code = EH, Country Name = Western Sahara
                    Country Code = ER, Country Name = Eritrea
                    Country Code = ES, Country Name = Spain
                    Country Code = ET, Country Name = Ethiopia
                    Country Code = FI, Country Name = Finland
                    Country Code = FJ, Country Name = Fiji
                    Country Code = FK, Country Name = Falkland Islands
                    Country Code = FM, Country Name = Micronesia
                    Country Code = FO, Country Name = Faroe Islands
                    Country Code = FR, Country Name = France
                    Country Code = GA, Country Name = Gabon
                    Country Code = GB, Country Name = United Kingdom
                    Country Code = GD, Country Name = Grenada
                    Country Code = GE, Country Name = Georgia
                    Country Code = GF, Country Name = French Guiana
                    Country Code = GG, Country Name = Guernsey
                    Country Code = GH, Country Name = Ghana
                    Country Code = GI, Country Name = Gibraltar
                    Country Code = GL, Country Name = Greenland
                    Country Code = GM, Country Name = Gambia
                    Country Code = GN, Country Name = Guinea
                    Country Code = GP, Country Name = Guadeloupe
                    Country Code = GQ, Country Name = Equatorial Guinea
                    Country Code = GR, Country Name = Greece
                    Country Code = GS, Country Name = South Georgia & South Sandwich Islands
                    Country Code = GT, Country Name = Guatemala
                    Country Code = GU, Country Name = Guam
                    Country Code = GW, Country Name = Guinea-Bissau
                    Country Code = GY, Country Name = Guyana
                    Country Code = HK, Country Name = Hong Kong SAR China
                    Country Code = HM, Country Name = Heard & McDonald Islands
                    Country Code = HN, Country Name = Honduras
                    Country Code = HR, Country Name = Croatia
                    Country Code = HT, Country Name = Haiti
                    Country Code = HU, Country Name = Hungary
                    Country Code = ID, Country Name = Indonesia
                    Country Code = IE, Country Name = Ireland
                    Country Code = IL, Country Name = Israel
                    Country Code = IM, Country Name = Isle of Man
                    Country Code = IN, Country Name = India
                    Country Code = IO, Country Name = British Indian Ocean Territory
                    Country Code = IQ, Country Name = Iraq
                    Country Code = IR, Country Name = Iran
                    Country Code = IS, Country Name = Iceland
                    Country Code = IT, Country Name = Italy
                    Country Code = JE, Country Name = Jersey
                    Country Code = JM, Country Name = Jamaica
                    Country Code = JO, Country Name = Jordan
                    Country Code = JP, Country Name = Japan
                    Country Code = KE, Country Name = Kenya
                    Country Code = KG, Country Name = Kyrgyzstan
                    Country Code = KH, Country Name = Cambodia
                    Country Code = KI, Country Name = Kiribati
                    Country Code = KM, Country Name = Comoros
                    Country Code = KN, Country Name = St. Kitts & Nevis
                    Country Code = KP, Country Name = North Korea
                    Country Code = KR, Country Name = South Korea
                    Country Code = KW, Country Name = Kuwait
                    Country Code = KY, Country Name = Cayman Islands
                    Country Code = KZ, Country Name = Kazakhstan
                    Country Code = LA, Country Name = Laos
                    Country Code = LB, Country Name = Lebanon
                    Country Code = LC, Country Name = St. Lucia
                    Country Code = LI, Country Name = Liechtenstein
                    Country Code = LK, Country Name = Sri Lanka
                    Country Code = LR, Country Name = Liberia
                    Country Code = LS, Country Name = Lesotho
                    Country Code = LT, Country Name = Lithuania
                    Country Code = LU, Country Name = Luxembourg
                    Country Code = LV, Country Name = Latvia
                    Country Code = LY, Country Name = Libya
                    Country Code = MA, Country Name = Morocco
                    Country Code = MC, Country Name = Monaco
                    Country Code = MD, Country Name = Moldova
                    Country Code = ME, Country Name = Montenegro
                    Country Code = MF, Country Name = St. Martin
                    Country Code = MG, Country Name = Madagascar
                    Country Code = MH, Country Name = Marshall Islands
                    Country Code = MK, Country Name = North Macedonia
                    Country Code = ML, Country Name = Mali
                    Country Code = MM, Country Name = Myanmar (Burma)
                    Country Code = MN, Country Name = Mongolia
                    Country Code = MO, Country Name = Macao SAR China
                    Country Code = MP, Country Name = Northern Mariana Islands
                    Country Code = MQ, Country Name = Martinique
                    Country Code = MR, Country Name = Mauritania
                    Country Code = MS, Country Name = Montserrat
                    Country Code = MT, Country Name = Malta
                    Country Code = MU, Country Name = Mauritius
                    Country Code = MV, Country Name = Maldives
                    Country Code = MW, Country Name = Malawi
                    Country Code = MX, Country Name = Mexico
                    Country Code = MY, Country Name = Malaysia
                    Country Code = MZ, Country Name = Mozambique
                    Country Code = NA, Country Name = Namibia
                    Country Code = NC, Country Name = New Caledonia
                    Country Code = NE, Country Name = Niger
                    Country Code = NF, Country Name = Norfolk Island
                    Country Code = NG, Country Name = Nigeria
                    Country Code = NI, Country Name = Nicaragua
                    Country Code = NL, Country Name = Netherlands
                    Country Code = NO, Country Name = Norway
                    Country Code = NP, Country Name = Nepal
                    Country Code = NR, Country Name = Nauru
                    Country Code = NU, Country Name = Niue
                    Country Code = NZ, Country Name = New Zealand
                    Country Code = OM, Country Name = Oman
                    Country Code = PA, Country Name = Panama
                    Country Code = PE, Country Name = Peru
                    Country Code = PF, Country Name = French Polynesia
                    Country Code = PG, Country Name = Papua New Guinea
                    Country Code = PH, Country Name = Philippines
                    Country Code = PK, Country Name = Pakistan
                    Country Code = PL, Country Name = Poland
                    Country Code = PM, Country Name = St. Pierre & Miquelon
                    Country Code = PN, Country Name = Pitcairn Islands
                    Country Code = PR, Country Name = Puerto Rico
                    Country Code = PS, Country Name = Palestinian Territories
                    Country Code = PT, Country Name = Portugal
                    Country Code = PW, Country Name = Palau
                    Country Code = PY, Country Name = Paraguay
                    Country Code = QA, Country Name = Qatar
                    Country Code = RE, Country Name = Réunion
                    Country Code = RO, Country Name = Romania
                    Country Code = RS, Country Name = Serbia
                    Country Code = RU, Country Name = Russia
                    Country Code = RW, Country Name = Rwanda
                    Country Code = SA, Country Name = Saudi Arabia
                    Country Code = SB, Country Name = Solomon Islands
                    Country Code = SC, Country Name = Seychelles
                    Country Code = SD, Country Name = Sudan
                    Country Code = SE, Country Name = Sweden
                    Country Code = SG, Country Name = Singapore
                    Country Code = SH, Country Name = St. Helena
                    Country Code = SI, Country Name = Slovenia
                    Country Code = SJ, Country Name = Svalbard & Jan Mayen
                    Country Code = SK, Country Name = Slovakia
                    Country Code = SL, Country Name = Sierra Leone
                    Country Code = SM, Country Name = San Marino
                    Country Code = SN, Country Name = Senegal
                    Country Code = SO, Country Name = Somalia
                    Country Code = SR, Country Name = Suriname
                    Country Code = SS, Country Name = South Sudan
                    Country Code = ST, Country Name = São Tomé & Príncipe
                    Country Code = SV, Country Name = El Salvador
                    Country Code = SX, Country Name = Sint Maarten
                    Country Code = SY, Country Name = Syria
                    Country Code = SZ, Country Name = Eswatini
                    Country Code = TC, Country Name = Turks & Caicos Islands
                    Country Code = TD, Country Name = Chad
                    Country Code = TF, Country Name = French Southern Territories
                    Country Code = TG, Country Name = Togo
                    Country Code = TH, Country Name = Thailand
                    Country Code = TJ, Country Name = Tajikistan
                    Country Code = TK, Country Name = Tokelau
                    Country Code = TL, Country Name = Timor-Leste
                    Country Code = TM, Country Name = Turkmenistan
                    Country Code = TN, Country Name = Tunisia
                    Country Code = TO, Country Name = Tonga
                    Country Code = TR, Country Name = Turkey
                    Country Code = TT, Country Name = Trinidad & Tobago
                    Country Code = TV, Country Name = Tuvalu
                    Country Code = TW, Country Name = Taiwan
                    Country Code = TZ, Country Name = Tanzania
                    Country Code = UA, Country Name = Ukraine
                    Country Code = UG, Country Name = Uganda
                    Country Code = UM, Country Name = U.S. Outlying Islands
                    Country Code = US, Country Name = United States
                    Country Code = UY, Country Name = Uruguay
                    Country Code = UZ, Country Name = Uzbekistan
                    Country Code = VA, Country Name = Vatican City
                    Country Code = VC, Country Name = St. Vincent & Grenadines
                    Country Code = VE, Country Name = Venezuela
                    Country Code = VG, Country Name = British Virgin Islands
                    Country Code = VI, Country Name = U.S. Virgin Islands
                    Country Code = VN, Country Name = Vietnam
                    Country Code = VU, Country Name = Vanuatu
                    Country Code = WF, Country Name = Wallis & Futuna
                    Country Code = WS, Country Name = Samoa
                    Country Code = YE, Country Name = Yemen
                    Country Code = YT, Country Name = Mayotte
                    Country Code = ZA, Country Name = South Africa
                    Country Code = ZM, Country Name = Zambia
                    Country Code = ZW, Country Name = Zimbabwe
                    Done""".replaceAll("\n", "").replaceAll("\r", ""), outputStreamCaptor.toString().trim().replaceAll("\n", "").replaceAll("\r", ""));
    }

}