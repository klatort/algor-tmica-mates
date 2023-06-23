import pygame

class Bullet():
    def __init__(self, x, sprite):
        self.sprite = sprite
        self.x = x
        self.y = 500
        self.dx = 0
        self.dy = 3