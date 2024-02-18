Integrantes:
Márquez Corona Danna Lizette
Romero Cruz Fernando

Instrucciones para ejecutar programa:

Respuestas a preguntas teóricas:
1. ¿Cuál es la representación en binario del número decimal 172_10?
    Para obtenerlo empezamos dividiendo 
    172/2=86 con un residuo de 0
    86/2=43 con residuo de 0
    43/2=21 con r de 1
    21/2=10 con r de 1
    10/2=5 con r de 0
    5/2=2 con r de 1
    2/2=1 con r de 0
    1/2=0 con r de 1
    y acomodando de abajo hacia arriba obtenemos: 10101100.

2. ¿Cuál es la representación en hexadecimal del número octal 74_8?
Primero pasamos de octal a decimal.
Tomamos cada unidad de el numero octal y lo multiplicamos por 8^n siendo n=la posición de la unidad de derecha
a izquierda empezando por el 0, posteriormente sumamos los resultados.
4*8^0=4
7*8^1=56
56+5=60 en decimal.
Luego pasamos de decimal a hexadecimal dividiendo.
60/16=3 con residuo de 12, el cual es C en hexadecimal.
12/16=0 con residuo de 3.
Asi, de abajo hacia arriba obtenemos que el número hexadecimal es 3C.

3. Desarrolla cuál es el número mínimo de bits requeridos para representar todos
los caracteres en un teclado que tiene...
• 9 letras.
= 4bits

• 16 letras.
= 5 bits

• 17 letras.
= 5 bits

4. En general, ¿es posible hacer la conversión entre una base n y una base m, para
cualquier n, m > 1 y n ̸= m? Desarrolla.
(Explicar bien luego.)
Sí es posible pasar de base n a m.
Primero pasas de base n a decimal (con eso de multiplicar por n^a siendo a la posición, luego sumas y te da como 
resultado un núm k en decimal)
Luego pasas de decimal a base m dividiendo m/k, finalmente ordenas empezando de los residuos finales a los iniciales.
