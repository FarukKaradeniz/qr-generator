# QR-Generator

---

This application creates a QR Code for given text.

[![Build](https://github.com/FarukKaradeniz/qr-generator/actions/workflows/maven.yml/badge.svg)](https://github.com/FarukKaradeniz/qr-generator/actions/workflows/maven.yml)
[![Bugs](https://sonarcloud.io/api/project_badges/measure?project=FarukKaradeniz_qr-generator&metric=bugs)](https://sonarcloud.io/dashboard?id=FarukKaradeniz_qr-generator)
[![Code Smells](https://sonarcloud.io/api/project_badges/measure?project=FarukKaradeniz_qr-generator&metric=code_smells)](https://sonarcloud.io/dashboard?id=FarukKaradeniz_qr-generator)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=FarukKaradeniz_qr-generator&metric=coverage)](https://sonarcloud.io/dashboard?id=FarukKaradeniz_qr-generator)
[![Duplicated Lines (%)](https://sonarcloud.io/api/project_badges/measure?project=FarukKaradeniz_qr-generator&metric=duplicated_lines_density)](https://sonarcloud.io/dashboard?id=FarukKaradeniz_qr-generator)
[![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=FarukKaradeniz_qr-generator&metric=ncloc)](https://sonarcloud.io/dashboard?id=FarukKaradeniz_qr-generator)
[![Maintainability Rating](https://sonarcloud.io/api/project_badges/measure?project=FarukKaradeniz_qr-generator&metric=sqale_rating)](https://sonarcloud.io/dashboard?id=FarukKaradeniz_qr-generator)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=FarukKaradeniz_qr-generator&metric=alert_status)](https://sonarcloud.io/dashboard?id=FarukKaradeniz_qr-generator)
[![Reliability Rating](https://sonarcloud.io/api/project_badges/measure?project=FarukKaradeniz_qr-generator&metric=reliability_rating)](https://sonarcloud.io/dashboard?id=FarukKaradeniz_qr-generator)
[![Security Rating](https://sonarcloud.io/api/project_badges/measure?project=FarukKaradeniz_qr-generator&metric=security_rating)](https://sonarcloud.io/dashboard?id=FarukKaradeniz_qr-generator)
[![Technical Debt](https://sonarcloud.io/api/project_badges/measure?project=FarukKaradeniz_qr-generator&metric=sqale_index)](https://sonarcloud.io/dashboard?id=FarukKaradeniz_qr-generator)
[![Vulnerabilities](https://sonarcloud.io/api/project_badges/measure?project=FarukKaradeniz_qr-generator&metric=vulnerabilities)](https://sonarcloud.io/dashboard?id=FarukKaradeniz_qr-generator)

## Example 1:

#### Request Payload:

```json
{
  "text": "farukkaradeniz.com"
}
```

#### Generated QR:

![QR Code](https://github.com/FarukKaradeniz/common-repository/raw/master/pictures/qr-text-farukkaradeniz.com.png)

---

## Example 2:

#### Request Payload:

```json
{
  "text": "farukkaradeniz.com",
  "color": "#1DA1F2",
  "size": "LARGE",
  "image": "/9j/4AAQ.../9k="
}

```

#### Generated QR:

![QR Code](https://github.com/FarukKaradeniz/common-repository/raw/master/pictures/qr-twitter-logo.png)

---

## Input:

POST Request Payload

```json
{
  "text": "farukkaradeniz.com",
  "color": "#FF0000",
  "backgroundColor": "#00FF00",
  "size": "MEDIUM",
  "image": "BASE64 ENCODED IMAGE"
}
```

| **Field**        | **Is Required**    |    **Available Inputs**    |
|-----------------	|:---------------:	|:-------------------------:	|
| text                |       Yes        | Any (Max 3096 characters)    |
| color            |        No        |   #00ff00, #44aa32 etc.    |
| backgroundColor    |        No        |   #00ff00, #44aa32 etc.    |
| size                |        No        |    SMALL, MEDIUM, LARGE    |
| image            |        No        |    Base64 Encoded Image    |
