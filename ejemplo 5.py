import pygame
from player import Player
from pygame.locals import *
 
class App():
    def __init__(self):
        self._running = True
        self._display_surf = None
        self.player = None
        self.clock = None
        self.size = self.weight, self.height = 640, 400
 
    def on_init(self):
        pygame.init()
        self._display_surf = pygame.display.set_mode(self.size, pygame.HWSURFACE | pygame.DOUBLEBUF)
        self._running = True
        self.player = Player(10, 20, "desktop/descarga.jpg")
        self.clock = pygame.time.Clock()
        self.clock.tick(60)
 
    def on_event(self, event):
        if event.type == QUIT:
            self.on_exit()
        keys = pygame.key.get_pressed()
        self.player.move(keys)

    def on_loop(self):
        pass

    def on_render(self):
        self._display_surf.fill(pygame.color.Color(255,255,255))
        self._display_surf.blit(self.player._sprite, self.player.pos)
        pygame.display.flip()

    def on_cleanup(self):
        pygame.quit()

    def on_exit(self):
        self._running = False

    def on_execute(self):
        if self.on_init() == False:
            self._running = False
 
        while( self._running ):
            for event in pygame.event.get():
                self.on_event(event)
            self.on_loop()
            self.on_render()
        self.on_cleanup()
 
 
if __name__ == "__main__" :
    theApp = App()
    theApp.on_execute()