# Echo Server

> Atividade prática da disciplina de Sistemas Distribuídos que busca demonstrar a troca de mensagens (pacotes) entre cliente e servidor usando uma aplicação Java.

## Procedimento

* Em ambos os hosts

Consulte o IP de ambos os hosts
```
ifconfig
```

Realize um teste de ping, a fim de garantir que estão conectados.
```
ping 192.168.XX.XXX
```
* No servidor

Caso o teste de ping esteja correto, mova o arquivo EchoServer.java para a pastapessoal dentro do diretório /home.
```
mv EchoServer.java /home/pastapessoal
```

Use o javac para compilar o arquivo java.
```
javac EchoServer.java
```

Após compilar, execute o programa. 
```
java EchoServer
```
Ele ficará com uma linha vazia e o cursos piscando. Isto indicará que a aplicação no Servidor está disponível para requisições

* No cliente

Use o telnet contendo o IP do servidor(XXX.XXX.XXX.XXX) e a porta(PPPP) definida na aplicação. 

```
telnet XXX.XXX.XXX.XXX PPPP
```

Uma mensagem interativa deverá aparecer no lado do cliente que fez a requisição.

## Cifra de César

Após seguir os passos descritos anteriormente, o arquivo <b>EchoServerCaesar.java</b> responderá a solicitação do usuário com uma mensagem criptografada conforme a [Cifra de César](https://pt.wikipedia.org/wiki/Cifra_de_C%C3%A9sar), usando Chave de valor 3. 

A implantação e uso deste algoritmo de criptografia permite que a mensagem que trafega do servidor para o cliente possa ter uma outra camada adicional de segurança. O sentido cliente servidor não obedece esta criptografia, pois a sua implementação é feita unicamente no lado servidor ([server-side](https://pt.wikipedia.org/wiki/Server-side)).

Para maiores detalhes do algoritmo, não deixe de visitar meu [Gist](https://gist.github.com/Gwolner/7b718d4d27ba097017ee1e25a62e4ec5).

## Teste criptografia

Trata-se da troca de mensagens numéricas do tipo Double do cliente para o servidor. O diferencial desta comunicação é que o cliente pode enviar uma quantidade aleatória de valores em sequencia, sem esperar que o servidor mante uma resposta após cada mensagem de envio. 

Esta quantidade aleatória é definida pelo método `10*Math.random()`, gerando numeros de 0 a 9, onde cada valor é fornecido na entrada padrão de dados pelo usuário (teclado).

Outro ponto importante para a execução de ambos os arquivos é que não dependem do `telnet XXX.XXX.XXX.XXX PPPP`, apenas  do `java EchoServer`.

Além destas características o comportamento dar-se da seguinte maneira: os números são enviados criptografados para o servidor, descriptografados, somados, criptografados novamente, enviado para o cliente, descriptografado e exibido na tela como resposta do somatório. 
