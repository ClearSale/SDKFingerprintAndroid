# SDKFingerprintAndroid

> Este projeto é um exemplo de como implementar a ferramenta Behavior Analytics SDK Android da ClearSale.

## 💻 Pré-requisitos
Para buildar este projeto de exemplo é necessário possuir:
- Gradle 4.0.2 ou superior
- O SDK do Android deve estar instalado e configurado corretamente

## 🤔 Explicação das dependências
1. com.google.android.gms:play-services-ads:20.6.0
> Essa dependência é usada para integrar anúncios do Google em um aplicativo Android.
2. com.google.android.gms:play-services-location:19.0.1
> Essa dependência é usada para obter a localização do dispositivo Android.
3. sale.clear.behavior:sdk-behavior:x.x.x
> Essa dependência é a usada para referenciar o Behavior Analytics SDK Android da ClearSale.

## 🔐 ProGuard
O ProGuard é uma ferramenta de otimização de código que é usada no fluxo de desenvolvimento do Android para reduzir o tamanho do APK final. Ele faz isso removendo o código que não é usado, obfuscando o código e comprimindo o APK final. Isso é útil porque permite que os usuários baixem e instalem o aplicativo mais rapidamente.

No entanto, o ProGuard pode ser problemático se ele remove o código que é necessário para o funcionamento do aplicativo. Para evitar isso, é necessário configurar o ProGuard para não remover o código que é necessário. Isso é feito usando o código como abaixo:

```
-keep class sale.clear.** { *; }
```
 
Este código diz ao ProGuard para não remover nenhuma classe ou membro de classe do pacote `sale.clear`. O `**` significa que isso se aplica a todos os subpacotes também.

Em resumo, o ProGuard é uma ferramenta útil para reduzir o tamanho do APK final, mas deve ser configurado corretamente para evitar problemas. O código acima é usado para garantir que o ProGuard não remova classes ou membros de classe importantes.

## ✨ Para mais detalhes
A documentação completa com informações sobre implementação da ferramenta Behavior Analytics SDK Android encontra-se em: 
[Wiki Android](https://api.clearsale.com.br/docs/behavior-analytics/sdk/android/latest#v5.0.1).


## 📫 Links que podem ser úteis
1. Como instalar o [SDK do Android](https://developer.android.com/about/versions/12/get?hl=pt-br).
2. Como configurar o [SDK do Android](https://developer.android.com/about/versions/12/setup-sdk?hl=pt-br).
3. Como instalar o [Gradle](https://docs.gradle.org/current/userguide/installation.html).

## 📝 MIT License

The MIT License (MIT)

Copyright ©  2023 ClearSale

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
