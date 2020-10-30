# Challenge for Mobile (Android and iOS) Developers

Crie um aplicativo para Android (Kotlin ou Java) ou iOS (Swift ou Object C) com as seguintes características:

* Criar uma tela de login onde o usuário precisa digitar um endereço de email válido.
* Armazene localmente o token retornado pela API no login.
* Após o login feito com sucesso, redirecione para uma tela onde deve conter as listas com as imagens
* Crie uma forma para que o usuário possa navegar entre as quatro raças de cachorros (`husky`, `labrador`, `hound` e `pug`)
* Ao clicar em uma imagem, ela deve ser exibida de forma expandida.

[doc da API](https://github.com/idwall/desafios-iddog)

## Instalação
* APK: Está anexado neste projeto o arquivo apk. O apk pode ser baixado clicando [aqui](https://github.com/ph-gaia/Desafio-Idwall-Android/blob/master/iddog-challenge.apk).

## Projeto
O projeto consiste em efetuar o login com um e-mail válido, e redirecionar para a tela de feed, onde é exibido uma lista com raças de cães. Ao ser clicado em uma das imagens, abre a visualização na tela inteira, ao abrir essa visualização é possível trocar de imagem apenas passando para os lados. O token do login foi gravado no shared Preference para requisitar a lista dos cães.

## Arquitetura
Neste projeto utilizei a arquitetura MVP pela facilidade de manutenção e futuras implementações.

## Bibliotecas
* [Retrofit](https://square.github.io/retrofit/): Biblioteca escolhida para requisições das APIs.
* [Gson](https://github.com/google/gson): Biblioteca da Google, para deserializar o retorno da API.
* [Picasso](https://github.com/square/picasso): Escolhi a biblioteca Picasso,  pois o carregamento de imagens sem complicações no aplicativo

# Author
- Paulo Henrique - phcgaia11@yahoo.com.br </br>
(https://www.linkedin.com/in/ph-gaia/)
