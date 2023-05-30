import math

def isPrime(n):
    if n <= 1:
        return False
    it = 2
    limit = math.sqrt(n + 1)
    while(it < limit):
        if(n % it == 0):
            return False
        it += 1
    return True

lista = []

n = int(input("Ingrese un valor "))
i = 0
while(len(lista) < n):
    i += 1
    if isPrime(i):
        lista.append(i)

print(lista)