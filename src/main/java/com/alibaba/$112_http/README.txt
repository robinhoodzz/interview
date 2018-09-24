通俗描述3次握手就是

A对B说：我的序号是x，我要向你请求连接；（第一次握手，发送SYN包，然后进入SYN-SEND状态）

B听到之后对A说：我的序号是y，期待你下一句序号是x+1的话（意思就是收到了序号为x的话，即ack=x+1），同意建立连接。（第二次握手，发送ACK-SYN包，然后进入SYN-RCVD状态）

A听到B说同意建立连接之后，对A说：与确认你同意与我连接（ack=y+1,ACK=1,seq=x+1）。（第三次握手，A已进入ESTABLISHED状态）

B听到A的确认之后，也进入ESTABLISHED状态。

---

描述四次挥手就是：

1.A与B交谈结束之后，A要结束此次会话，对B说：我要关闭连接了（seq=u,FIN=1）。（第一次挥手，A进入FIN-WAIT-1）

2.B收到A的消息后说：确认，你要关闭连接了。（seq=v,ack=u+1,ACK=1）（第二次挥手，B进入CLOSE-WAIT）

3.A收到B的确认后,等了一段时间，因为B可能还有话要对他说。（此时A进入FIN-WAIT-2）

4.B说完了他要说的话（只是可能还有话说）之后，对A说，我要关闭连接了。（seq=w, ack=u+1,FIN=1，ACK=1）(第三次挥手)
5.A收到B要结束连接的消息后说：已收到你要关闭连接的消息。（seq=u+1,ack=w+1,ACK=1）(第四次挥手，然后A进入CLOSED)
6.B收到A的确认后，也进入CLOSED。

---------------------

本文来自 KogRow 的CSDN 博客 ，全文地址请点击：https://blog.csdn.net/shuaicenglou3032/article/details/67634938?utm_source=copy