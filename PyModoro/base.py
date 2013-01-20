#!/usr/bin/env python

# Copyright 2013 Cedric Meury
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#      http://www.apache.org/licenses/LICENSE-2.0
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

import pygtk
import gtk, gobject
pygtk.require('2.0')

import time

VERSION = "0.1"

class Base:

    is_started = False
    time_started = time.time()
    POMODORO_LENGTH_SECS = (24 * 60)

    def time_left(self):
        now = time.time()
        difference = now - self.time_started
        return self.POMODORO_LENGTH_SECS - difference

    def time_left_string(self):
        left = self.time_left()
        minutes = int(round(left / 60))
        seconds = int(round(left % 60))
        # prevent display of 24:60 right after start. this introduces
        # the defective behaviour of 24:59 being shown for 2 seconds
        # bearable for the moment, needs to be solved waaayyy differently
        if seconds == 60:
            minutes += 1
            seconds = 0
        return str.format("{0:02d}:{1:02d}", minutes, seconds)

    def quitting(self, widget, event, data=None):
        print "Quitting!"

    def start_pomodoro(self, widget, event, data=None):
        if self.is_started:
            print "Pomodoro already started!"
            return
        self.time_started = time.time()
        self.timer = gobject.timeout_add (100, self.progress_timeout, self)
        self.progress_bar.set_text(self.time_left_string())
        self.is_started = True
        print "Pomodoro started!"

    def progress_timeout(self, pbobj):
        self.progress_bar.set_fraction(self.time_left() / self.POMODORO_LENGTH_SECS)
        self.progress_bar.set_text(self.time_left_string())
        return True

    def delete_event(self, widget, event, data=None):
        return False

    def destroy(self, widget, data=None):
        if self.is_started:
            gobject.source_remove(self.timer)
            self.timer = 0
        gtk.main_quit()

    def create_main_window(self):
        self.window = gtk.Window(gtk.WINDOW_TOPLEVEL)
        self.window.set_title("PyModoro " + VERSION)
        self.window.set_default_size(height=60, width=200)
        self.window.set_border_width(10)
        self.window.connect("delete_event", self.delete_event)
        self.window.connect("destroy", self.destroy)

    def create_quit_button(self,):
        self.quit_button = gtk.Button("Quit")
        self.quit_button.connect("clicked", self.quitting, None)
        self.quit_button.connect_object("clicked", gtk.Widget.destroy, self.window)
        self.quit_button.show()


    def create_start_button(self):
        self.start_button = gtk.Button("Start Pomodoro")
        self.start_button.connect("clicked", self.start_pomodoro, None)
        self.start_button.show()

    def create_progress_bar(self):
        self.progress_bar = gtk.ProgressBar(adjustment=None)
        self.progress_bar.set_orientation(gtk.PROGRESS_LEFT_TO_RIGHT)
        self.progress_bar.set_text("25:00")
        self.progress_bar.set_fraction(1)
        self.progress_bar.show()

    def create_status_icon(self):
        # Icon from http://www.iconarchive.com/show/artcore-4-icons-by-artcore-illustrations.html
        # License: CC Attribution-Noncommercial-No Derivate 3.0
        # Homepage: http://blog.artcore-illustrations.de/aicons/
        self.status_icon = gtk.status_icon_new_from_file("fraise-icon.png")
        self.status_icon.set_has_tooltip(True)
        self.status_icon.set_tooltip_text("PyModoro " + VERSION)
        self.status_icon.connect("popup-menu", self.popup, None)
        self.status_icon.set_visible(True)

    def popup(self, icon, button, activate_time, data=None):
#        self.uimanager.get_widget('/tray_menu').show()
        self.tray_menu.popup(None, None, None, button, activate_time)
        print "Popup!"

    def create_tray_menu(self):
#        actiongroup = gtk.ActionGroup("tray_menu")
#        self.uimanager = gtk.UIManager()
#        self.uimanager.insert_action_group(actiongroup, 0)
#        merge_id = self.uimanager.add_ui_from_file("tray_menu.xml")
#        tray_menu = self.uimanager.get_widget('/tray_menu')
#        tray_menu.popup()
        self.tray_menu = gtk.Menu()
        self.menu_start = gtk.MenuItem("Start Pomodoro")
        self.menu_cancel = gtk.MenuItem("Cancel Pomodoro")
        self.menu_quit = gtk.MenuItem("Quit")
        self.tray_menu.append(self.menu_start)
        self.tray_menu.append(self.menu_cancel)
        self.tray_menu.append(self.menu_quit)
        self.menu_start.connect("activate", self.start_pomodoro, None)
        self.menu_cancel.connect("activate", self.quitting, None)
        self.menu_quit.connect("activate", self.quitting, None)


    def __init__(self):
        self.create_main_window()

        self.box1 = gtk.HBox(False, 0)
        self.window.add(self.box1)

        self.create_progress_bar()
        self.box1.pack_start(self.progress_bar)
        self.create_start_button()
        self.box1.pack_start(self.start_button, True, True, 0)
        self.create_quit_button()
        self.box1.pack_start(self.quit_button, False, True, 0)
        self.box1.show()

        self.window.show()

        self.create_status_icon()
        self.create_tray_menu()

    def main(self):
        gtk.main()



print __name__
if __name__ == "__main__":
    base = Base()
    base.main()
