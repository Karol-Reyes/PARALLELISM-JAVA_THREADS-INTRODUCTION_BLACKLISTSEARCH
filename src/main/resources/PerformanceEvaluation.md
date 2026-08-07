# Respuesta parte III

## Modificación Main

Como se nos solicita el poder realizar las ejecuciones para diferentes *n*, haremos una modificación con respecto al main para no tener que recompilar el programa cada vez y medir así efectivamente el tiempo de ejecución de cada uno.

Mas sin embargo, para no cambiar el main original del BlackListValidator, creamos una clase llamada [PerformanceTest.java](/src/main/java/edu/eci/arsw/blacklistvalidator/PerformanceTest.java) con las modificaciones necesarias para realizar este proceso.

## Tiempos de ejecuión

### 1. Un Hilo.

con el fin de comenzar con la ejecución de un solo hilo, desde nuestra terminar realizamos la ejecución de este comando

```java edu.eci.arsw.blacklistvalidator.PerformanceTest 1```

el resultado obtenido en la terminal es el siguiente:

![UnHilo](img/UnHilo.png)

donde obtenemos que con *1 solo hilo*, el tiempo de ejecución fue de *373287 ms, es decir, un aproximado de 6,22 minutos*

y el resultado mostrado por jVisualVM es el siguiente:

![UsoUnHilo](img/UnHiloUsage.png)

donde obtenemos:
- consumo (max) de CPU: 1.1%
- consumo (max) de memoria: 28.147.712 B

---

### 2. Tantos hilos como núcleos de procesamiento.

con el fin de comenzar con la ejecución de la misma cantidad de hilos como nucleos de procesamiento, desde nuestra terminar realizamos la ejecución de este comando

```java edu.eci.arsw.blacklistvalidator.PerformanceTest```

No le ingresamos el numero específico de hilos ya que para eso estamos utilizando el ```getRuntime()```en nuestro codigo, que accede directamente a la cantidad de nucleos que posee la máquina

el resultado obtenido en la terminal es el siguiente:

![16Hilos](img/16Hilos.png)

donde obtenemos que con *16 hilos* (cantidad de nucleos de la máquina), el tiempo de ejecución fue de *14965 ms, es decir, un aproximado de 0,25 minutos*

y el resultado mostrado por jVisualVM es el siguiente:

![Uso16Hilos](img/16HilosUsage.png)

donde obtenemos:
- consumo (max) de CPU: 1.0%
- consumo (max) de memoria: 20.236.584 B

---

### 3. Tantos hilos como el doble de núcleos de procesamiento.

con el fin de comenzar con la ejecución del doble de hilos que el punto pasado (es decir, 32 hilos), desde nuestra terminar realizamos la ejecución de este comando

```java edu.eci.arsw.blacklistvalidator.PerformanceTest 32```

el resultado obtenido en la terminal es el siguiente:

![32Hilos](img/32Hilos.png)

donde obtenemos que con *32 hilos* ( doble de cantidad de nucleos de la máquina), el tiempo de ejecución fue de *6372 ms, es decir, un aproximado de 0,11 minutos*

y el resultado mostrado por jVisualVM es el siguiente:

![Uso32Hilos](img/32HilosUsage.png)

donde obtenemos:
- consumo (max) de CPU: numero negativo, es decir, el tiempo de ejecución fue demasiado rápido y jVisualVM no pudo calcularlo
- consumo (max) de memoria: 20.035.712 B

---

### 4. 50 Hilos.

con el fin de comenzar con la ejecución de 50 hilos, desde nuestra terminar realizamos la ejecución de este comando

```java edu.eci.arsw.blacklistvalidator.PerformanceTest 50```

el resultado obtenido en la terminal es el siguiente:

![50Hilos](img/50Hilos.png)

donde obtenemos que con *50 hilos*, el tiempo de ejecución fue de *2001 ms, es decir, un aproximado de 0,034 minutos*

y el resultado mostrado por jVisualVM es el siguiente:

![Uso50Hilos](img/50HilosUsage.png)

donde obtenemos:
- consumo (max) de CPU: número muy pequeño (negativo) para calcularlo, dato no disponible
- consumo (max) de memoria: 5.189.832 B

----

### 5. 100 Hilos.

con el fin de comenzar con la ejecución de 100 hilos, desde nuestra terminar realizamos la ejecución de este comando

```java edu.eci.arsw.blacklistvalidator.PerformanceTest 100```

el resultado obtenido en la terminal es el siguiente:

![100Hilos](img/100Hilos.png)

donde obtenemos que con *100 hilos*, el tiempo de ejecución fue de *1052 ms, es decir, un aproximado de 0,018 minutos*

y el resultado mostrado por jVisualVM es el siguiente:

![Uso100Hilos](img/100HilosUsage.png)

donde obtenemos:
- consumo (max) de CPU: número muy pequeño (negativo) para calcularlo, dato no disponible
- consumo (max) de memoria: 21.934.248 B

## Gráfica Hilos vs Tiempo Solución

A continuación, se muestra la gráfica obtenida de los resultados expuestos anteriormente en la ejecución del programa:

![Gráfica](img/Grafica.png)

Como podemos observar, la curva muestra un decrecimiento no lineal (en un ajuste potencial, R^2=0,9999): el tiempo cae drásticamente de 1 a 16 hilos (de 373s a 15s), porque ahí el paralelismo aprovecha de núcleos reales disponibles. 

De 16 a 32 sigue bajando pero menos (15s --> 6,4s), ya con más hilos que núcleos físicos. 

De 32 a 100 la curva se aplana (6,4s --> 2s --> 1s) en rendimientos decrecientes, lo que quiere decir que, pasado el número de núcleos, agregar más hilos ya no da paralelismo real, solo trabajo extra y gasto adicional con una ganancia extra marginal.

**Mayor conclusión encontrada:** el mayor beneficio del paralelismo se obtiene cerca del número de núcleos disponibles; superar eso trae ganancias cada vez menores.