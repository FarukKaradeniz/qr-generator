# QR-Generator

---

This application creates a QR Code for given text.

[![Build](https://github.com/FarukKaradeniz/qr-generator/actions/workflows/maven.yml/badge.svg)](https://github.com/FarukKaradeniz/qr-generator/actions/workflows/maven.yml)

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
