import pickle
from invader import Invader

invader2 = Invader(30,40,"Otro sprite.jpg")

fIn = open("invader2.txt", "ab")

pickle.dump(invader2, fIn)
fIn.close()

fOut = open("invader2.txt","rb")

invader = pickle.load(fOut)
print(invader.sprite)

fOut.close()