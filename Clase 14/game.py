import pygame
import random
import math
import pickle
from bullet import Bullet
from player import Player
from invader import Invader
from pygame import mixer

class GameManager():
    def __init__(self):
        self.player = None
        self.bullets = []
        self.invaders = []
        self.running = True
        self.font = None
        self.screen = None
        self.game_over_font = None
        self.screen_width = 800
        self.screen_height = 600
        self.score_val = 0
        self.game_over = False
        self.bullet_sprite = None
        self.invader_sprite = None
        self.player_sprite = None
        self.clock = None
        self.key_buffer = []

    def on_init(self):
        self.player = Player()
        self.bullet_sprite = pygame.image.load('data/bullet.png')
        self.invader_sprite = pygame.image.load('data/alien.png')
        self.player_sprite = pygame.image.load('data/spaceship.png')

        pygame.init() 

        self.clock = pygame.time.Clock()

        self.screen = pygame.display.set_mode((self.screen_width, self.screen_height))

        self.font = pygame.font.Font('freesansbold.ttf', 20)
        self.game_over_font = pygame.font.Font('freesansbold.ttf', 64)

        fEnemigos = open("enemigos.dat","rb")
        self.invaders = pickle.load(fEnemigos)    
        fEnemigos.close()

        pygame.display.set_caption("Welcome to Space Invaders Game by:- styles")

        mixer.music.load('data/background.wav')
        mixer.music.play(-1)

    def on_event(self):
        for event in pygame.event.get():
            if event.type == pygame.QUIT:
                self.running = False
            if event.type == pygame.KEYDOWN:
                if event.key == pygame.K_LEFT:
                    if self.key_buffer.count(pygame.K_LEFT) == 0:
                        self.key_buffer.append(pygame.K_LEFT)
                if event.key == pygame.K_RIGHT:
                    if self.key_buffer.count(pygame.K_RIGHT) == 0:
                        self.key_buffer.append(pygame.K_RIGHT)
                if event.key == pygame.K_SPACE:
                    
                    self.bullets.append(Bullet(self.player.x, self.bullet_sprite))
                    
                    bullet_sound = mixer.Sound('data/bullet.wav')
                    bullet_sound.play()
            if event.type == pygame.KEYUP:
                if event.key == pygame.K_LEFT:
                    self.key_buffer.remove(pygame.K_LEFT)
                if event.key == pygame.K_RIGHT:
                    self.key_buffer.remove(pygame.K_RIGHT)

    def on_loop(self):  
        for key in self.key_buffer:
            if key == pygame.K_LEFT:
                self.player.x -= 1
            if key == pygame.K_RIGHT:
                self.player.x += 1
            
        for invader in self.invaders:
            invader.x += invader.dx 

        for bullet in self.bullets:
            bullet.y -= bullet.dy 
            if bullet.y < -10:
                self.bullets.remove(bullet)
                break

        for invader in self.invaders:
            if invader.y >= 450:
                if abs(self.player.x - invader.x) < 80:
                    for i in self.invaders:
                        i.y = 2000
                        explosion_sound = mixer.Sound('data/explosion.wav')
                        explosion_sound.play()
                    self.game_over = True
                    break

            if invader.x >= 735 or invader.x <= 0:
                invader.dx *= -1
                invader.y += invader.dy

            for bullet in self.bullets:
                collision = self.isCollision(bullet.x, invader.x, bullet.y, invader.y)
                if collision:
                    self.score_val += 1
                    invader.x = random.randint(64, 736)
                    invader.y = random.randint(30, 200)
                    
                    if(self.bullets.remove(bullet)):
                        break
            if self.player.x <= 16:
                self.player.x = 16
            elif self.player.x >= 750:
                self.player.x = 750
        self.clock.tick(480)



    def on_render(self):
        self.screen.fill((0, 0, 0))

        for bullet in self.bullets:
            self.screen.blit(self.bullet_sprite, (bullet.x, bullet.y))

        for invader in self.invaders:    
            self.screen.blit(self.invader_sprite, (invader.x,invader.y))
        score = self.font.render("Points: " + str(self.score_val), True, (255,255,255))
        self.screen.blit(self.player_sprite, (self.player.x - 16, self.player.y - 20))
        self.screen.blit(score, (5 , 5))
        if(self.game_over):
            game_over_text = self.game_over_font.render("GAME OVER", True, (255,255,255))
            self.screen.blit(game_over_text, (190, 250))
        pygame.display.update()
    
    def on_cleanup(self):
        pygame.quit()

    def on_exit(self):
        self.running = False

    def on_execute(self):
        if self.on_init() == False:
            self.running = False
 
        while( self.running ):
            self.on_event()
            self.on_loop()
            self.on_render()
        self.on_cleanup()

    def isCollision(self, x1, x2, y1, y2):
        distance = math.sqrt((math.pow(x1 - x2,2)) + (math.pow(y1 - y2,2)))
        if distance <= 50:
            return True
        else:
            return False
    

 
if __name__ == "__main__" :
    theApp = GameManager()
    theApp.on_execute()