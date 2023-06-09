import pygame
from pygame.locals import *

class Player():
    def __init__(self, x, y, path) -> None:
        self.pos = self.x, self.y = x, y
        self._sprite = pygame.image.load(path).convert()
        self.w = self._sprite.get_width()
        self.h = self._sprite.get_height()
    
    def move(self, keys):
        if keys[K_w]:
            self.y -= 10
        if keys[K_a]:
            self.x -= 10
        if keys[K_s]:
            self.y += 10
        if keys[K_d]:
            self.x += 10
        self.pos = self.x, self.y

if __name__ == "__main__" :
    theApp = Player()