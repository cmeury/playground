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
    POMODORO_LENGTH_SECS = 24 * 60

    def time_left(self):
        now = time.time()
        difference = now - self.time_started
        return self.POMODORO_LENGTH_SECS - difference

    def time_left_string(self):
        left = self.time_left()
        minutes = left / 60
        seconds = left % 60
        return str.format("{0:d}:{1:d}", int(round(minutes)), int(round(seconds)))

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
        self.progress_bar.show()

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

    def main(self):
        gtk.main()



print __name__
if __name__ == "__main__":
    base = Base()
    base.main()
