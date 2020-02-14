# troca-de-mensagem

Troca de mensagem entre dois terminais na disciplina de  sistemas Distribuídos. 

Uso do código java testar dois hosts

Consulte o IP via terminal usando o seguinte comando:
```
ifconfig
```

Realize um teste de ping no IP do cliente e servidor para garantir a conectividade dos terminais.
```
ping 192.168.XX.XXX
```

Caso o teste de ping esteja correto, mova o arquivo EchoServer.java de onde estiver, para o destino 

```
mv EchoServer.java /home/pastapessoal
```

```
javac EchoServer.java
```

```
java EchoServer
```

```
telnet 192.168.X.XXX 8189
```

