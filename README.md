# QR-Generator

---

This application creates a QR Code for given text.

## Example:

#### Given text:

farukkaradeniz.com

#### Generated QR:

![QR Code](https://github.com/FarukKaradeniz/common-repository/raw/master/pictures/qr-text-farukkaradeniz.com.png)

POST Request Payload

```json
{
  "text": "farukkaradeniz.com",
  "color": "#FF0000",
  "backgroundColor": "#00FF00",
  "shape": "SQUARE",
  "size": "MEDIUM",
  "image": "BASE64 IMAGE"
}
```

| **Field**        | **Is Required**    |    **Available Inputs**    |
|-----------------	|:---------------:	|:-------------------------:	|
| text                |       Yes        | Any (Max 3096 characters)    |
| color            |        No        |   #00ff00, #44aa32 etc.    |
| backgroundColor    |        No        |   #00ff00, #44aa32 etc.    |
| size                |        No        |    SMALL, MEDIUM, LARGE    |
| shape            |        No        |       SQUARE, CIRCLE        |
| image            |        No        |    Base64 Encoded Image    |