import pygame

class Player():
    def __init__(self):
        self.sprite = pygame.image.load('data/spaceship.png')
        self.x = 370
        self.y = 523
        self.dx = 0
        self.invincible = False