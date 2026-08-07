# Respuesta Parte IV

---

**1.** El mejor desempeño no se logra con 500 hilos, ya que como vemos en la ecuación, el término $\frac{P}{n}$ se va haciendo más pequeño conforme la cantidad de hilos (n) crece. En el caso ideal, cuando n tiende a infinito, este término tiende a cero. Sin embargo, incluso en ese caso ideal, queda el término $1 - P$, la cual no depende de la cantidad de hilos, por lo que, este término es el que define el techo o que tanto puede mejorar el algoritmo, sin importar la cantidad de hilos.

Por otra parte, el desempeño de este comparado a usar 200 hilos es mínimo, ya que mientras más hilos agregamos, el rendimiento cada vez mejora menos, o sea si mejora pero no tanto como al principio, ya que como dijimos antes, al techo ser la función $1 - P$, la cantidad de hilos mientras más sean, menos influyen. 

**2.** Al usar el doble de hilos (por ejemplo, pasando de n núcleos a 2n), la mejora en el desempeño no se duplica proporcionalmente, porque la relación entre n y S(n) no es lineal — es una función de tipo $/frac{1}{n}$, es decir, aunque ahi una mejora real, pero muy por debajo del doble. Esto ocurre porque cuanto más se incrementa n, más nos acercamos al límite teórico, el margen de mejora se va reduciendo.

**3.** si pudiéramos tener 1 hilo en 100 CPU's en vez de 100 hilos en 1 CPU, técnicamente por la ley de Amdahls no habría cambios, ya que los hilos (n) serían 100, sin importar donde estén, por lo que no cambia el valor si está en una CPU o en 100.

Asi mismo, al estar en 100 máquinas distribuidas, no se mejoraría, ya que ahora el cuello de botella sería el tiempo de comunicación entre hilos de cada núcleo, ya que al estar todos los hilos separados, se demoran más en comunicarse entre sí que tenerlos todos en una sola CPU.

Ahora para los c hilos en 100/c máquinas, este si mejora, ya que dentro de cada máquina con c hilos, su comunicación es más rápida al tener memoria compartida, al igual que el caso de una sola CPU.