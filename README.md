# Troca de mensagens entre cliente e servidor

Atividade prática da disciplina de Sistemas Distribuídos que busca demonstrar a troca de mensagens (pacotes) entre cliente e servidor usando uma aplicação Java.

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
