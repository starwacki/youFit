-- MySQL dump 10.13  Distrib 8.0.30, for Win64 (x86_64)
--
-- Host: localhost    Database: youfit
-- ------------------------------------------------------
-- Server version	8.0.30

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `language`
--

DROP TABLE IF EXISTS `language`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `language` (
  `language-id` int NOT NULL,
  `language-name` varchar(45) NOT NULL,
  PRIMARY KEY (`language-id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `language`
--

LOCK TABLES `language` WRITE;
/*!40000 ALTER TABLE `language` DISABLE KEYS */;
/*!40000 ALTER TABLE `language` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `meals`
--

DROP TABLE IF EXISTS `meals`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `meals` (
  `meal-id` int NOT NULL,
  `meal-name` varchar(45) NOT NULL,
  PRIMARY KEY (`meal-id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `meals`
--

LOCK TABLES `meals` WRITE;
/*!40000 ALTER TABLE `meals` DISABLE KEYS */;
/*!40000 ALTER TABLE `meals` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `products`
--

DROP TABLE IF EXISTS `products`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `products` (
  `produt-id` int NOT NULL,
  `base-language` int NOT NULL,
  `name` varchar(80) NOT NULL,
  `producer` varchar(30) DEFAULT NULL,
  `kcal-per-100g` float NOT NULL,
  `proteins-per-100g` float NOT NULL,
  `carbohydrates-per-100g` float NOT NULL,
  `fat-per-100g` float NOT NULL,
  PRIMARY KEY (`produt-id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `products`
--

LOCK TABLES `products` WRITE;
/*!40000 ALTER TABLE `products` DISABLE KEYS */;
INSERT INTO `products` VALUES (1,1,'Agrest','BRAK',41,0.8,11.8,0.2),(2,1,'Amarantus. nasiona','BRAK',400,14.5,66.2,6.5),(3,1,'Ananas','BRAK',54,0.4,13.6,0.2),(4,1,'Ananas w syropie','BRAK',84,0.4,21,0.1),(5,1,'Anyż','BRAK',337,17.6,50,16),(6,1,'Arbuz','BRAK',36,0.6,8.4,0.1),(7,1,'Avocado','BRAK',160,2,7.4,15.3),(8,1,'Bakłażan','BRAK',21,1.1,6.3,0.1),(9,1,'Baleron','BRAK',244,15.1,0.9,20.2),(10,1,'Banan','BRAK',95,1,23.5,0.3),(11,1,'Banany suszone','BRAK',360,3.8,88.8,1.1),(12,1,'Bazylia suszona','BRAK',251,14.3,61,4),(13,1,'Bazylia świeża','BRAK',23,3.2,2.7,0.64),(14,1,'Biała rzodkiew','BRAK',14,1,3,0),(15,1,'Białko jajka kurzego','BRAK',49,10.9,0.7,0.2),(16,1,'Bób','BRAK',66,7.1,14,0.4),(17,1,'Boćwina','BRAK',17,2.1,5.5,0.5),(18,1,'Boczek wędzony','BRAK',477,13,0,47),(19,1,'Botwinka','BRAK',17,2.1,5.5,0.5),(20,1,'Brokuły','BRAK',27,3,5.2,0.4),(21,1,'Brukselka','BRAK',37,4.7,8.7,0.5),(22,1,'Brzoskwinia','BRAK',46,1,11.9,0.2),(23,1,'Brzoskwinia w syropie','BRAK',73,0.4,18.2,0.1),(24,1,'Bułka owsiana','BRAK',304,9.3,58.4,4.5),(25,1,'Bułka pszenna zwykła','BRAK',273,8.1,57.7,1.5),(26,1,'Bułka sojowa','BRAK',315,10.1,61.1,4),(27,1,'Bułka tarta','BRAK',347,9.7,77.6,1.9),(28,1,'Bułka wrocławskia','BRAK',294,8,56.6,4.4),(29,1,'Burak','BRAK',38,1.8,9.5,0.1),(30,1,'Cebula','BRAK',30,1.4,6.9,0.4),(31,1,'Cebula czerwona','BRAK',30,1.4,6.9,0.4),(32,1,'Cebula konserwowa','BRAK',52,0.7,12.4,0.2),(33,1,'Cebulka dymka','BRAK',30,1.4,6.9,0.4),(34,1,'Chili','BRAK',40,0.4,1.8,0.1),(35,1,'Chleb chrupki','BRAK',353,8.7,78.9,2.4),(36,1,'Chleb pszenny','BRAK',257,8.5,54.3,1.4),(37,1,'Chleb zwykły','BRAK',248,6.1,56.3,1.3),(38,1,'Chleb żytni pełnoziarnisty','BRAK',225,6.8,53.8,1.8),(39,1,'Chleb żytni razowy','BRAK',213,5.9,51.2,1.7),(40,1,'Chrzan','BRAK',67,4.5,18.1,0.6),(41,1,'Ciecierzyca konserwowa','BRAK',127,6,18,3),(42,1,'Cieciorka','BRAK',364,19.3,60.6,6),(43,1,'Cielęcina łopatka','BRAK',106,19.9,0,2.8),(44,1,'Cielęcina sznyclówka','BRAK',105,20.5,0,2.4),(45,1,'Cielęcina udziec','BRAK',108,19.9,0,3.1),(46,1,'Cukier','BRAK',405,0,99.8,0),(47,1,'Cukier brązowy','BRAK',380,0.12,98,0),(48,1,'Cukier puder','BRAK',387,0,100,0),(49,1,'Cukinia','BRAK',15,1.2,3.2,0.1),(50,1,'Curry','BRAK',325,13,58,14),(51,1,'Ćwikła','BRAK',40,1.6,10.2,0.1),(52,1,'Cykoria','BRAK',21,1.7,4.1,0.2),(53,1,'Cynamon','BRAK',247,4,81,1.2),(54,1,'Cytryna','BRAK',36,0.8,9.5,0.3),(55,1,'Czekolada gorzka','BRAK',554,6.7,56.6,34.3),(56,1,'Czereśnie','BRAK',61,1,14.6,0.3),(57,1,'Czerwona fasola konserwowa ','BRAK',87,8.1,12.3,0.6),(58,1,'Czosnek','BRAK',146,6.4,32.6,0.5),(59,1,'Czosnek granulowany','BRAK',331,17,73,0.73),(60,1,'Daktyle suszone','BRAK',277,2,74,0.4),(61,1,'Dorsz filety bez skóry','BRAK',70,16.5,0,0.3),(62,1,'Dynia','BRAK',28,1.3,7.7,0.3),(63,1,'Dżem jagodowy niskosłodzony','BRAK',153,0.3,38.2,0.2),(64,1,'Dżem śliwkowy niskosłodzony','BRAK',153,0.3,37.9,0.1),(65,1,'Dżem truskawkowy niskosłodzony','BRAK',153,0.3,37.8,0.2),(66,1,'Dżem wiśniowy niskosłodzony','BRAK',154,0.4,37.5,0.2),(67,1,'Ekstrakt z wanilii','BRAK',288,0.03,14,0),(68,1,'Estragon','BRAK',295,23,50,7.2),(69,1,'Fasola biała suche nasiona','BRAK',288,21.4,61.6,1.6),(70,1,'Fasola cięta. konserwowa. bez zalewy','BRAK',16,1.5,4.5,0.2),(71,1,'Fasola szparagowa','BRAK',27,2.4,7.6,0.2),(72,1,'Fasolka szparagowa. mrożonka','BRAK',24,2.2,6.8,0.2),(73,1,'Figi suszone','BRAK',290,3.6,78,1.2),(74,1,'Filet z makreli w sosie pomidorowym','BRAK',150,13.1,4,9),(75,1,'Flądra świeża','BRAK',83,16.5,0,1.8),(76,1,'Gałka muszkatołowa','BRAK',475,6.7,50,32),(77,1,'Goździk','BRAK',323,6,61,20),(78,1,'Grahamka','BRAK',252,9,56.1,1.7),(79,1,'Granat','BRAK',83,1.7,18.7,1.2),(80,1,'Grejpfrut','BRAK',36,0.6,9.8,0.2),(81,1,'Grejpfrut czerwony','BRAK',42,0.8,10.7,0.1),(82,1,'Grejpfrut zielony','BRAK',36,0.6,9.8,0.2),(83,1,'Groch suche nasiona','BRAK',293,23.8,60.2,1.4),(84,1,'Groszek ptysiowy','BRAK',476,14.9,37.6,30.2),(85,1,'Groszek zielony','BRAK',75,6.7,17,0.4),(86,1,'Groszek zielony konserwowy','BRAK',63,4.9,15.8,0.2),(87,1,'Gruszka','BRAK',54,0.6,14.4,0.2),(88,1,'Grzyby suszone','BRAK',284,9.3,73,0.7),(89,1,'Halibut świeży','BRAK',98,20.1,0,1.9),(90,1,'Herbata bez cukru','BRAK',0,0.1,0,0),(91,1,'Imbir','BRAK',347,9.1,71,6),(92,1,'Jabłka suszone','BRAK',238,2.1,62.3,2.1),(93,1,'Jabłko','BRAK',46,0.4,12.1,0.4),(94,1,'Jagody','BRAK',45,0.8,12.2,0.6),(95,1,'Jajko kurze','BRAK',139,12.5,0.6,9.7),(96,1,'Jajko przepiórcze','BRAK',158,13,0.4,11),(97,1,'Jarmuż','BRAK',29,3.3,6.1,0.7),(98,1,'Jogurt naturalny 2%','BRAK',60,4.3,6.2,2),(99,1,'Kabanos','BRAK',326,27.4,0,24.3),(100,1,'Kabanos z kurczaka','BRAK',247,22.8,0.1,17.4),(101,1,'Kajzerka','BRAK',296,8.4,58.6,3.6),(102,1,'Kakao w proszku 16%','BRAK',448,18.2,50.6,21.7),(103,1,'Kalafior','BRAK',22,2.4,5,0.2),(104,1,'Kalarepa','BRAK',29,2.2,6.5,0.3),(105,1,'Kapary','BRAK',23,2.4,4.9,0.9),(106,1,'Kapusta biała','BRAK',29,1.7,7.4,0.2),(107,1,'Kapusta czerwona','BRAK',27,1.9,6.7,0.2),(108,1,'Kapusta kwaszona','BRAK',12,1.1,3.4,0.2),(109,1,'Kapusta pekińska','BRAK',12,1.2,3.2,0.2),(110,1,'Kapusta włoska','BRAK',38,3.3,7.8,0.4),(111,1,'Kardamon','BRAK',311,11,68,6.7),(112,1,'Karp świeży','BRAK',110,18,0,4.2),(113,1,'Kasza gryczana','BRAK',336,12.6,69.3,3.1),(114,1,'Kasza jaglana','BRAK',346,10.5,71.6,2.9),(115,1,'Kasza jęczmienna pęczak','BRAK',334,8.4,74.9,2),(116,1,'Kasza jęczmienna perłowa','BRAK',327,6.9,75,2.2),(117,1,'Kasza kukurydziana','BRAK',337,8,72,1.7),(118,1,'Kasza manna','BRAK',348,8.7,76.7,1.3),(119,1,'Kaszanka jęczmienna','BRAK',195,8.5,13,12.6),(120,1,'Kawa bez cukru','BRAK',2,0.2,0.3,0),(121,1,'Keczup','BRAK',93,1.8,22.2,1),(122,1,'Kefir 2%','BRAK',51,3.4,4.7,2),(123,1,'Kefir 2% z wapniem','BRAK',51,3.4,4.7,2),(124,1,'Kiełbasa delikatesowa z kurczaka','BRAK',109,19.6,0.1,3.3),(125,1,'Kiełbasa domowa','BRAK',320,14.7,0.5,29.2),(126,1,'Kiełbasa jałowcowa z kurczaka','BRAK',236,19,0.1,17.9),(127,1,'Kiełbasa kanapkowa z kurczaka','BRAK',179,11.8,3,13.5),(128,1,'Kiełbasa lubuska','BRAK',249,17.5,4.8,18),(129,1,'Kiełbasa parówkowa','BRAK',323,11,0,31.5),(130,1,'Kiełbasa podlaska z kurczaka','BRAK',232,20.7,0.1,16.7),(131,1,'Kiełbasa podsuszana z kurczaka','BRAK',162,21.7,0,8.4),(132,1,'Kiełbasa podwawelska','BRAK',247,17.3,0.9,19.6),(133,1,'Kiełbasa rzeszowska','BRAK',203,20.9,0,13.4),(134,1,'Kiełbasa śląska','BRAK',210,18.4,0,15.3),(135,1,'Kiełbasa sucha krakowska','BRAK',323,25.6,0,24.8),(136,1,'Kiełbasa sucha myśliwska','BRAK',291,27.8,0,20.1),(137,1,'Kiełbasa szynkowa z kurczaka','BRAK',110,16.2,0,5),(138,1,'Kiełbasa toruńska','BRAK',263,20.9,0,20.1),(139,1,'Kiełbasa zwyczajna','BRAK',209,17.6,0,15.6),(140,1,'Kiełbasa żywiecka','BRAK',315,20.3,0,26.3),(141,1,'Kiełbaski bawarskie','BRAK',308,15.5,0.1,27.7),(142,1,'Kiełki bambusa','BRAK',20,1.1,2,0.6),(143,1,'Kiełki brokuła','BRAK',57,5,6.8,0),(144,1,'Kiełki buraka','BRAK',37,1.6,9.6,0.2),(145,1,'Kiełki fasoli mung','BRAK',29,3,6.2,0.4),(146,1,'Kiełki lucerny','BRAK',23,4,2.1,0.7),(147,1,'Kiełki rzodkiewki','BRAK',43,3.8,3.6,2.5),(148,1,'Kiełki słonecznika','BRAK',31,3.4,4,0.7),(149,1,'Kiełki soczewicy','BRAK',119,9,22.1,0.6),(150,1,'Kiełki soi','BRAK',141,13.1,9.6,6.7),(151,1,'Kiwi','BRAK',56,0.9,13.9,0.5),(152,1,'Kminek','BRAK',333,20,50,15),(153,1,'Kolendra','BRAK',279,22,52,4.8),(154,1,'Komosa ryżowa - quinoa','BRAK',334,14.8,58.5,5),(155,1,'Komosa ryżowa - Quinoa','BRAK',334,15,58,5),(156,1,'Koncentrat pomidorowy 30%','BRAK',92,5.6,16.7,1.5),(157,1,'Koperek','BRAK',26,2.8,6.1,0.4),(158,1,'Kostka rosołowa Rosół z kury z pietruszką i lubczykiem ','BRAK',300,10,10,20),(159,1,'Krewetka tygrysia','BRAK',92,22,1,0),(160,1,'Kukurydza kolba','BRAK',110,3.7,23.4,1.5),(161,1,'Kukurydza konserwowa','BRAK',102,2.9,23.6,1.2),(162,1,'Kumin (kmin rzymski)','BRAK',429,17,34,22),(163,1,'Kurki','BRAK',32,1.49,6.86,0.53),(164,1,'Kurkuma','BRAK',354,7.8,65,9.9),(165,1,'Len mielony','BRAK',253,40,3,9),(166,1,'Len w nasionach','BRAK',500,24.5,35,31),(167,1,'Limonka','BRAK',30,0.7,10.5,0.2),(168,1,'Liście mięty','BRAK',77,3.8,15,0.94),(169,1,'Liść laurowy','BRAK',313,7.6,75,8.4),(170,1,'Łosoś smażony','BRAK',380,21.2,4,31.4),(171,1,'Łosoś świeży','BRAK',201,19.9,0,13.6),(172,1,'Łosoś wędzony','BRAK',162,21.5,0,8.4),(173,1,'Magii','BRAK',17,2.7,1.5,0),(174,1,'Majeranek','BRAK',271,13,61,7),(175,1,'Majonez','BRAK',714,1.3,2.6,79),(176,1,'Mak','BRAK',478,20.1,24.7,42.9),(177,1,'Mąka kukurydziana','BRAK',337,5.9,78,3),(178,1,'Mąka pszenna typ 1850','BRAK',309,11.9,70,2.3),(179,1,'Mąka pszenna typ 500','BRAK',343,10.1,74,1.2),(180,1,'Mąka pszenna typ 550','BRAK',344,10.5,73,1.6),(181,1,'Mąka pszenna typ 750','BRAK',341,11.6,71.3,1.8),(182,1,'Makaron bezjajeczny','BRAK',364,11,77.6,1.6),(183,1,'Makaron czterojajeczny','BRAK',391,13.2,78.3,3.4),(184,1,'Makaron dwujajeczny','BRAK',373,12,76.8,2.6),(185,1,'Makaron farfalline pełnoziarnisty z 5 zbóż','BRAK',351,14.4,63.8,2.5),(186,1,'Makaron penne pełnoziarnisty','BRAK',345,15.2,68,1.3),(187,1,'Makaron rurki (z pszenicy Durum)','BRAK',350,12,72.1,1.5),(188,1,'Makaron ryżowy','BRAK',356,6.8,83,0.7),(189,1,'Makaron spaghetti razowy','BRAK',354,13,66.5,2.5),(190,1,'Mąka ryżowa','BRAK',348,7.2,79.2,0.7),(191,1,'Mąka żytnia typ 1400','BRAK',310,7.1,75.3,2.2),(192,1,'Mąka żytnia typ 2000','BRAK',301,8.1,74,2.2),(193,1,'Mąka żytnia typ 580','BRAK',330,5.1,78.5,1.5),(194,1,'Mąka żytnia typ 720','BRAK',327,5.9,77.4,1.7),(195,1,'Makrela świeża','BRAK',181,18.7,0,11.9),(196,1,'Makrela wędzona','BRAK',221,20.7,0,15.5),(197,1,'Maliny','BRAK',29,1.3,12,0.3),(198,1,'Mandarynki','BRAK',42,0.6,11.2,0.2),(199,1,'Mango','BRAK',67,0.5,17,0.3),(200,1,'Marchewka','BRAK',27,1,8.7,0.2),(201,1,'Marchewka z groszkiem. mrożonka','BRAK',39,2.6,10.4,0.3),(202,1,'Marchewki mini','BRAK',41,1,9,0),(203,1,'Maślanka 0.5 %','BRAK',37,3.4,4.7,0.5),(204,1,'Masło ekstra','BRAK',735,0.7,0.7,82.5),(205,1,'Masło klarowane','BRAK',883,0,0,99),(206,1,'Masło orzechowe','BRAK',634,26.6,8.5,53),(207,1,'Masło śmietankowe','BRAK',659,1.1,1.1,73.5),(208,1,'Melon','BRAK',36,0.9,8.4,0.3),(209,1,'Mieszanka mąk gryczanej. ryżowej lub owsianej','BRAK',351,11.7,70.7,2.7),(210,1,'Mieszanka warzywna z kurczakiem. ryżem i grzybami chińskimi. mrożonka','BRAK',87,4.3,13.3,2.4),(211,1,'Mieszanka ziół','BRAK',1,0,0,0.1),(212,1,'Mięta pieprzowa','BRAK',77,3.8,15,0.94),(213,1,'Migdały','BRAK',572,20,20.5,52),(214,1,'Miks ulubionych warzwy','BRAK',38,1.9,8.8,0.3),(215,1,'Mintaj świeży','BRAK',73,16.6,0,0.6),(216,1,'Miód pszczeli','BRAK',324,0.3,79.5,0),(217,1,'Mleko kokosowe w puszce','BRAK',203,2.1,8.1,18),(218,1,'Mleko kozie 2%','BRAK',68,3.2,4.5,4.1),(219,1,'Mleko owcze','BRAK',107,6,5.1,7),(220,1,'Mleko sojowe','BRAK',41,6,4.3,1.4),(221,1,'Mleko spożywcze 2.0%','BRAK',51,3.4,4.9,2),(222,1,'Mleko w proszku pełne','BRAK',479,27,38.7,24),(223,1,'Mleko zagęszczone niesłodzone','BRAK',131,6.6,9.4,7.5),(224,1,'Mleko zagęszczone słodzone','BRAK',326,7.5,55.3,8),(225,1,'Młody jęczmień proszek','BRAK',320,52,21,2),(226,1,'Morele','BRAK',47,0.9,11.9,0.2),(227,1,'Morele suszone','BRAK',284,5.4,72.2,1.2),(228,1,'Morszczuk świeży','BRAK',89,17.2,0,2.2),(229,1,'Mus jabłkowy','BRAK',124,2.2,28.7,0.2),(230,1,'Musli z orzechami i rodzynkami','BRAK',375,11.5,62.9,12.7),(231,1,'Musli z suszonymi owocami','BRAK',325,8.4,72.2,3.4),(232,1,'Musztarda','BRAK',162,5.7,22,6.4),(233,1,'Napój kokosowy w kartonie','BRAK',30,0.1,3.5,2),(234,1,'Nasiona Chia','BRAK',490,16,44,31),(235,1,'Natka pietruszki','BRAK',41,4.4,9,0.4),(236,1,'Nektarynka','BRAK',48,0.9,11.8,0.2),(237,1,'Ocet balsamiczny','BRAK',116,0,0.7,0),(238,1,'Ocet jabłkowy','BRAK',24,0,6,0),(239,1,'Ocet winny','BRAK',20,0,5,0),(240,1,'Ogórek','BRAK',13,0.7,2.9,0.1),(241,1,'Ogórek kiszony','BRAK',11,1,1.9,0.1),(242,1,'Ogórek konserwowy','BRAK',23,0.4,4.9,0.1),(243,1,'Ogórek kwaszony','BRAK',11,1,1.9,0.1),(244,1,'Ogórki konserwowe','BRAK',24,0.3,5.6,0.1),(245,1,'Olej kokosowy','BRAK',900,0,0,100),(246,1,'Olej rzepakowy','BRAK',884,0,0,100),(247,1,'Olej słonecznikowy','BRAK',884,0,0,100),(248,1,'Oliwa z oliwek','BRAK',882,0,0.2,99.6),(249,1,'Oliwki czarne','BRAK',125,1.4,4.1,12.7),(250,1,'Oliwki zielone marynowane','BRAK',125,1.4,4.1,12.7),(251,1,'Oregano','BRAK',265,9,69,4.3),(252,1,'Orzechy arachidowe','BRAK',560,25.7,19.2,46.1),(253,1,'Orzechy brazylijskie','BRAK',656,14,4,66),(254,1,'Orzechy laskowe','BRAK',640,14.4,14.9,63),(255,1,'Orzechy piniowe','BRAK',673,16.7,13,68.4),(256,1,'Orzechy pistacjowe','BRAK',589,20.5,25,48.5),(257,1,'Orzechy włoskie','BRAK',645,16,18,60.3),(258,1,'Orzechy ziemne','BRAK',603,26,14,50),(259,1,'Ostra papryka','BRAK',0.4,0.02,0.09,0),(260,1,'Otręby pszenne','BRAK',185,16,61.9,4.6),(261,1,'Paluszek krabowy','BRAK',113,6.5,16.8,2.2),(262,1,'Papaja','BRAK',41,0.6,11.1,0.1),(263,1,'Papryka czerwona','BRAK',28,1.3,6.6,0.5),(264,1,'Papryka czerwona konserwowa','BRAK',30,0.8,5,1.5),(265,1,'Papryka sucha','BRAK',289,15,56,13),(266,1,'Papryka zielona','BRAK',18,1.1,4.6,0.3),(267,1,'Pasternak','BRAK',57,1.6,15.5,0.6),(268,1,'Pasztet pieczony','BRAK',390,17,13.5,31.2),(269,1,'Pasztet podlaski z kurczaka','BRAK',228,6.7,3.6,21.1),(270,1,'Pasztet z kurczaka','BRAK',214,14.4,7.5,14.3),(271,1,'Pestki dyni','BRAK',556,24.5,18,45.8),(272,1,'Pestki słonecznika','BRAK',561,24.4,24.6,43.7),(273,1,'Pesto','BRAK',340,3.7,6.3,34.6),(274,1,'Pieczarki','BRAK',17,2.7,2.6,0.4),(275,1,'Pieczarki marynowane konserwowe','BRAK',19,2.3,4.3,0.4),(276,1,'Pieczeń wołowa','BRAK',117,20.9,0,3.6),(277,1,'Pieczona polędwica wołowa','BRAK',168,19.7,0,9.9),(278,1,'Pieczywo tostowe','BRAK',305,8.1,58.8,4.7),(279,1,'Pieczywo tostowe grahamowe','BRAK',273,7.5,53.8,4.2),(280,1,'Pieczywo Wasa','BRAK',370,10,70,3),(281,1,'Pieprz biały','BRAK',296,10,69,2.1),(282,1,'Pieprz czarny','BRAK',318,11,65,3.3),(283,1,'Pieprz czerwony','BRAK',318,12,57,17),(284,1,'Pierś indyka bez skóry','BRAK',84,19.2,0,0.7),(285,1,'Pierś indyka ze skórą','BRAK',100,18.7,0,2.7),(286,1,'Pierś kurczaka bez skóry','BRAK',99,21.5,0,1.3),(287,1,'Pietruszka','BRAK',38,2.6,10.5,0.5),(288,1,'Pikle konserwowe','BRAK',62,1.3,15.5,0.2),(289,1,'Płatki jaglane','BRAK',361,10,69,4),(290,1,'Płatki jęczmienne','BRAK',355,9.8,79.4,3.6),(291,1,'Płatki kukurydziane','BRAK',363,6.9,83.6,2.5),(292,1,'Płatki migdałowe','BRAK',581,22,10,51),(293,1,'Płatki owsiane','BRAK',366,11.9,69.3,7.2),(294,1,'Płatki pszenne','BRAK',351,9,81,3),(295,1,'Płatki ryżowe','BRAK',344,6.7,78.9,0.7),(296,1,'Płatki żytnie','BRAK',343,6.4,82.6,3.2),(297,1,'Podudzie indyka bez skóry','BRAK',100,16.6,0,3.7),(298,1,'Polędwica łososiowa','BRAK',106,20,2,2),(299,1,'Polędwica luksusowa','BRAK',177,19.5,2.4,10),(300,1,'Polędwica sopocka','BRAK',165,19.9,0.9,9.1),(301,1,'Polędwica wołowa','BRAK',113,20.1,0,3.5),(302,1,'Polędwica z indyka','BRAK',105,15.8,0.1,4.6),(303,1,'Polędwica z piersi kurczaka','BRAK',93,20.4,0,1.2),(304,1,'Pomarańcza','BRAK',44,0.9,11.3,0.2),(305,1,'Pomidor','BRAK',15,0.9,3.6,0.2),(306,1,'Pomidory koktajlowe','BRAK',15,0.9,3.6,0.2),(307,1,'Pomidory z puszki','BRAK',23,1.3,4,0.2),(308,1,'Por','BRAK',24,2.2,5.7,0.3),(309,1,'Porzeczki białe','BRAK',33,1,13.1,0.2),(310,1,'Porzeczki czarne','BRAK',35,1.3,14.9,0.2),(311,1,'Porzeczki czerwone','BRAK',31,1.1,13.8,0.2),(312,1,'Powidła śliwkowe','BRAK',214,1,53,0.2),(313,1,'Poziomki','BRAK',33,0.8,8.3,0.5),(314,1,'Proszek do pieczenia','BRAK',97,0.1,47,0.4),(315,1,'Przecier pomidorowy','BRAK',25,1.2,4.5,0.1),(316,1,'Przyprawa do drobiu','BRAK',307,9.6,66,7.5),(317,1,'Przyprawa do ryb','BRAK',307,9.6,66,7.5),(318,1,'Przyprawa \"Jarzynka\"','BRAK',90,1.9,23.3,0.4),(319,1,'Pstrąg strumieniowy świeży','BRAK',97,19.2,0,2.1),(320,1,'Pstrąg tęczowy świeży','BRAK',160,18.6,0,9.6),(321,1,'Pstrąg wędzony','BRAK',117,19.4,0.2,4.4),(322,1,'Pumpernikiel','BRAK',240,5.9,58.2,2),(323,1,'Rabarbar','BRAK',9,0.5,4.6,0.1),(324,1,'Rodzynki suszone','BRAK',277,2.3,71.2,0.5),(325,1,'Rostbef wołowy','BRAK',152,21.5,0,7.3),(326,1,'Rozmaryn','BRAK',331,4.9,64,15),(327,1,'Rukola','BRAK',25,2.6,3.7,0.7),(328,1,'Ryż biały','BRAK',344,6.7,78.9,0.7),(329,1,'Ryż brązowy','BRAK',322,7.1,76.8,1.9),(330,1,'Rzepa','BRAK',26,1.1,8.2,0.3),(331,1,'Rzeżucha','BRAK',32,2.6,5.5,0.7),(332,1,'Rzodkiewka','BRAK',14,1,4.4,0.2),(333,1,'Salami','BRAK',540,21.9,0.9,50.6),(334,1,'Salami popularne','BRAK',568,21.6,1.4,53.7),(335,1,'Salami z pieprzem','BRAK',405,17,1,37),(336,1,'Sałata','BRAK',14,1.4,2.9,0.2),(337,1,'Sałata lodowa','BRAK',14,0.9,3,0.1),(338,1,'Sałata rzymska','BRAK',17,1.2,3,0),(339,1,'Sandacz świeży','BRAK',84,19.2,0,0.7),(340,1,'Sardynki w oleju','BRAK',221,24.1,0,13.9),(341,1,'Sardynki w pomidorach','BRAK',162,17,1.4,9.9),(342,1,'Schab pieczony','BRAK',291,30.4,0.7,18.7),(343,1,'Seler konserwowy','BRAK',17,0.7,5.4,0.1),(344,1,'Seler korzeniowy','BRAK',21,1.6,7.7,0.3),(345,1,'Seler naciowy','BRAK',13,1,3.6,0.2),(346,1,'Ser Brie pełnotłusty','BRAK',329,19.8,0.2,28),(347,1,'Ser Camembert pełnotłusty','BRAK',291,21.4,0.2,23),(348,1,'Ser Cheddar pełnotłusty','BRAK',391,27.1,0.1,31.7),(349,1,'Ser Edamski pełnotłusty','BRAK',313,26.1,0.1,23.4),(350,1,'Serek homogenizowany','BRAK',161,12.7,3,11),(351,1,'Serek homogenizowany waniliowy','BRAK',159,16.8,13.3,4.2),(352,1,'Serek twarogowy ziarnisty','BRAK',101,12.3,3.3,4.3),(353,1,'Serek typu \"Fromage\" naturalny','BRAK',379,10.2,2.4,37.1),(354,1,'Ser Ementaler pełnotłusty','BRAK',380,28.8,0.1,29.7),(355,1,'Ser Gouda pełnotłusty','BRAK',316,27.9,0.1,22.9),(356,1,'Ser kozi','BRAK',388,21.4,0,33.9),(357,1,'Ser kozi. twarożek','BRAK',168,8.7,4,14),(358,1,'Ser Mascarpone','BRAK',394,3.5,5.1,40),(359,1,'Ser mozzarella','BRAK',254,24,3,16),(360,1,'Ser mozzarella light','BRAK',157,19,1,8.5),(361,1,'Ser Parmezan','BRAK',452,41.5,0.1,32),(362,1,'Ser Radamer','BRAK',339,26.2,0.1,26),(363,1,'Ser Rokpol pełnotłusty','BRAK',363,22.6,0.1,30.6),(364,1,'Ser Salami pełnotłusty','BRAK',351,25.2,0.1,28.1),(365,1,'Ser topiony','BRAK',298,13.5,1.2,27),(366,1,'Ser Trapistów pełnotłusty','BRAK',367,23.5,0.1,30.7),(367,1,'Ser Trapistów tłusty','BRAK',351,28,0.1,26.8),(368,1,'Ser twarogowy chudy','BRAK',99,19.8,3.5,0.5),(369,1,'Ser twarogowy półtłusty','BRAK',133,18.7,3.7,4.7),(370,1,'Ser twarogowy tłusty','BRAK',175,17.7,3.5,10.1),(371,1,'Ser Tylżycki pełnotłusty','BRAK',353,26.1,0.1,27.9),(372,1,'Ser typu \"Feta\"','BRAK',215,17,1,16),(373,1,'Sezam','BRAK',632,23.2,10,59.9),(374,1,'Siemie lniane','BRAK',534,18,29,42),(375,1,'Skórka cytrynowa','BRAK',120,1.6,25,0.2),(376,1,'Skrobia kukurydziana','BRAK',353,0.2,88.5,0),(377,1,'Skrobia ziemniaczana','BRAK',343,0.6,83.9,0.1),(378,1,'Śledź solony','BRAK',217,19.8,0,15.4),(379,1,'Śledź w oleju','BRAK',301,16.4,0,26.5),(380,1,'Śliwka','BRAK',45,0.6,11.7,0.2),(381,1,'Śliwki suszone','BRAK',267,3.5,68.9,1.2),(382,1,'Słodki ziemniak (batat)','BRAK',86,1.6,20,0.1),(383,1,'Śmietana. 12% tłuszczu','BRAK',133,2.7,3.9,12),(384,1,'Śmietana. 18% tłuszczu','BRAK',184,2.5,3.6,18),(385,1,'Śmietanka kremowa 30%','BRAK',287,2.2,3.1,30),(386,1,'Soczewica czerwona suche nasiona','BRAK',327,25.4,57.5,3),(387,1,'Soja suche nasiona','BRAK',382,34.3,32.7,19.6),(388,1,'Sok ananasowy','BRAK',48,0.3,11.4,0.1),(389,1,'Sok brzoskwiniowo pomarańczowy','BRAK',32,0.7,7.4,0.1),(390,1,'Sok buraczany','BRAK',34,0.8,7.6,0.2),(391,1,'Sok cytrynowy','BRAK',30,0.4,6.4,0.3),(392,1,'Sok egzotyczny','BRAK',57,0.8,12.7,0.3),(393,1,'Sok grejpfrutowy','BRAK',40,0.5,9.2,0.1),(394,1,'Sok jabłkowy','BRAK',42,0.1,10,0.1),(395,1,'Sok marchwiowo brzoskwiniowy','BRAK',44,0.5,11.3,0.1),(396,1,'Sok marchwiowo jabłkowo bananowy','BRAK',39,0.3,10.2,0.1),(397,1,'Sok marchwiowo jabłkowo śliwkowy','BRAK',39,0.4,10.2,0.2),(398,1,'Sok marchwiowo jabłkowy','BRAK',44,0.5,12.1,0.2),(399,1,'Sok marchwiowo pomarańczowy','BRAK',40,0.6,10.8,0.1),(400,1,'Sok marchwiowy','BRAK',43,0.4,11.3,0.1),(401,1,'Sok pomarańczowo grejpfrutowy','BRAK',43,0.6,9.8,0.1),(402,1,'Sok pomarańczowy','BRAK',43,0.6,9.9,0.1),(403,1,'Sok pomidorowy','BRAK',14,0.8,3.3,0.2),(404,1,'Sok wieloowocowy','BRAK',45,0.2,10.9,0.1),(405,1,'Sok wielowarzywny','BRAK',25,1,5.7,0.3),(406,1,'Sól','BRAK',0,0,0,0),(407,1,'Sola świeża','BRAK',83,17.5,0,1.4),(408,1,'Sól czosnkowa','BRAK',9,4.3,1.9,1.2),(409,1,'Sos sojowy','BRAK',0,0.6,0.3,0),(410,1,'Starta skórka z pomarańczy','BRAK',120,1.6,25,0.2),(411,1,'Suszone pomidory','BRAK',215,5,23,14),(412,1,'Syrop klonowy','BRAK',265,0.1,63,0.1),(413,1,'Szafran','BRAK',310,11,65,5.9),(414,1,'Szałwia','BRAK',315,11,61,13),(415,1,'Szczaw','BRAK',21,1.1,4.9,0.8),(416,1,'Szczupak świeży','BRAK',82,18.4,0,0.8),(417,1,'Szczypiorek','BRAK',29,4.1,3.9,0.8),(418,1,'Szparagi','BRAK',18,1.9,3.7,0.2),(419,1,'Szpinak','BRAK',16,2.6,3,0.4),(420,1,'Szpinak. mrożonka','BRAK',15,2.3,2.7,0.4),(421,1,'Szponder wołowy','BRAK',217,19.3,0,15.7),(422,1,'Szprotka wędzona','BRAK',243,19.3,0,18.3),(423,1,'Szynka delikatesowa z kurczaka','BRAK',123,18.2,0,5.6),(424,1,'Szynka kanapkowa','BRAK',102,14.2,1.4,4.4),(425,1,'Szynka parmeńska','BRAK',135,26,1,3),(426,1,'Szynka wiejska','BRAK',253,17.1,0.9,20.3),(427,1,'Szynka wieprzowa gotowana','BRAK',233,16.4,1,18.3),(428,1,'Szynka wołowa gotowana','BRAK',107,20.9,1.1,2),(429,1,'Szynka z indyka','BRAK',84,17.1,0.1,1.6),(430,1,'Szynka z piersi kurczaka','BRAK',98,21.2,0.2,1.2),(431,1,'Szynka z udźca kurczaka','BRAK',117,17.2,0,5.3),(432,1,'Szynkówka wieprzowa','BRAK',191,13.6,1.4,14.7),(433,1,'Szynkówka wołowa','BRAK',85,16.2,1.4,1.5),(434,1,'Tofu','BRAK',112,12,3,6),(435,1,'Truskawki','BRAK',28,0.7,7.2,0.4),(436,1,'Tuńczyk w oleju','BRAK',190,27.1,0,9),(437,1,'Tuńczyk w sosie własnym','BRAK',96,21,0,1.2),(438,1,'Tymianek','BRAK',276,9.1,64,7.4),(439,1,'Udko kurczaka bez skóry','BRAK',125,17.8,0,6),(440,1,'Udko kurczaka ze skórą','BRAK',158,16.8,0,10.2),(441,1,'Udziec indyka bez skóry','BRAK',104,19.4,0,2.8),(442,1,'Udziec indyka ze skórą','BRAK',131,18.4,0,6.4),(443,1,'Wafle ryżowe','BRAK',390,8,81,3),(444,1,'Wątróbka kurczaka','BRAK',136,19.1,0.6,6.3),(445,1,'Wędzona pierś z kurczaka','BRAK',107,23,0,0.5),(446,1,'Wędzonka wołowa gotowana','BRAK',102,17.8,0.5,3.1),(447,1,'Wieprzowina karkówka','BRAK',267,16.1,0,22.8),(448,1,'Wieprzowina łopatka','BRAK',257,16,0,21.7),(449,1,'Wieprzowina schab surowy','BRAK',174,21,0,10),(450,1,'Wieprzowina żeberka','BRAK',321,15.2,0,29.3),(451,1,'Wino białe półwytrawne','BRAK',81,0,3.7,0),(452,1,'Wino białe słodkie','BRAK',95,0.2,5.9,0),(453,1,'Wino białe wytrawne','BRAK',66,0.1,0.6,0),(454,1,'Wino czerwone','BRAK',68,0.1,0.2,0),(455,1,'Winogrona','BRAK',69,0.5,17.6,0.2),(456,1,'Wiórki kokosowe','BRAK',606,5.6,27,63.2),(457,1,'Wiśnie','BRAK',47,0.9,10.9,0.4),(458,1,'Włoszczyzna krojona w paski','BRAK',25,1.4,7.9,0.3),(459,1,'Woda','BRAK',0,0,0,0),(460,1,'Zarodki pszenne','BRAK',323,27.5,45.5,9.4),(461,1,'Żelatyna','BRAK',343,84.2,0,0.1),(462,1,'Ziele angielskie','BRAK',263,6.1,72,8.7),(463,1,'Ziemniaki','BRAK',77,1.9,18.3,0.1),(464,1,'Ziemniaki młode','BRAK',69,1.8,16.3,0.1),(465,1,'Zioła prowansalskie','BRAK',1,0,0,0.1),(466,1,'Żółtko jajka kurzego','BRAK',314,15.5,0.3,28.2),(467,1,'Żurawina niskosłodzona do mięs','BRAK',161,0.2,38.8,0.7),(468,1,'Żurawina suszona','BRAK',320,0.1,82.4,1.4);
/*!40000 ALTER TABLE `products` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `email` varchar(65) NOT NULL,
  `date_of_birth` date NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'user1','password1','user@gmail.com','1999-12-10'),(2,'user2','password2','user2@gmail.com','1999-12-10'),(3,'user3','password3','user3@gmail.com','1999-12-10'),(4,'user4','password4','user4@gmail.com','1999-12-10'),(5,'user5','password5','user5@gmail.com','1999-12-10'),(6,'user6','password6','user6@gmail.com','1999-12-10'),(7,'user7','password7','user7@gmail.com','1999-12-10'),(8,'user8','password8','user8@gmail.com','1999-12-10'),(9,'user9','password9','user9@gmail.com','1999-12-10'),(10,'user10','password10','user10@gmail.com','1999-12-10'),(11,'user11','password11','user11@gmail.com','1999-12-10'),(12,'user12','password12','user12@gmail.com','1999-12-10'),(13,'user13','password13','user13@gmail.com','1999-12-10'),(14,'user14','password14','user14@gmail.com','2002-06-09'),(15,'registertest0','registertest0','registertest-','2022-09-30'),(16,'registertest1','registertest1','registertest1','2022-09-03');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `youfitbase`
--

DROP TABLE IF EXISTS `youfitbase`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `youfitbase` (
  `user_id` int NOT NULL,
  `meal_id` int NOT NULL,
  `product_id` int NOT NULL,
  `date` date NOT NULL,
  `product_weight` decimal(10,0) NOT NULL,
  `product_index_in_meal` int NOT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `youfitbase`
--

LOCK TABLES `youfitbase` WRITE;
/*!40000 ALTER TABLE `youfitbase` DISABLE KEYS */;
INSERT INTO `youfitbase` VALUES (1,1,1,'2022-10-12',100,0,1),(1,1,3,'2022-10-12',150,1,2),(1,1,6,'2022-10-12',90,2,3),(1,2,4,'2022-10-12',120,0,4),(1,1,4,'2022-10-16',55,0,6),(1,1,114,'2022-10-16',100,1,11),(1,1,3,'2022-10-17',55,0,18),(1,1,6,'2022-10-17',55,1,19),(1,3,6,'2022-10-12',55,0,20),(1,3,41,'2022-10-23',100,0,22),(1,3,358,'2022-10-23',100,1,23),(2,2,6,'2022-10-12',555,0,24);
/*!40000 ALTER TABLE `youfitbase` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-10-17 12:48:17
