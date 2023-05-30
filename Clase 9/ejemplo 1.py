import random

lista = []

for i in range(10):
    lista.append(random.randint(0, 3))

print(lista)
aux = []
for p, pivot in enumerate(lista):
    repetido = False
    for i in range(p + 1, len(lista)):
        if pivot == lista[i]:
            repetido = True
            break
    if not repetido:
        aux.append(pivot)

print(aux)