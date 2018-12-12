# Project 1 - TODOAPP

TODOAPP is an android app that allows building a todo list and basic todo items management functionality including adding new items, editing and deleting an existing item.

Submitted by: Sparky Evangelista

Time spent: **3** hours spent in total

## User Stories

The following **required** functionality is completed:

* [x] User can **view a list of todo items**
* [x] User can **successfully add and remove items** from the todo list
* [x] User's **list of items persisted** upon modification and and retrieved properly on app restart

The following **optional** features are implemented:

* [x] User can **tap a todo item in the list and bring up an edit screen for the todo item** and then have any changes to the text reflected in the todo list

The following **additional** features are implemented:

* [ ] User's can **re-order the items on the list** 
* [ ] User's can **prioritize** the items the put on a certain list

## Video Walkthrough

Here's a walkthrough of implemented user stories:

<img src="Walkthrough .gif" title='Video Walkthrough' width='' alt='Video Walkthrough' />

GIF created with [LiceCap](http://www.cockos.com/licecap/).

## Notes

I encountered some challenges like learning how to use Andriod Studio for the first time. It wasn't so much of a challenge but it was somewhat difficult for me. Another challenge I faced was time management, doing this a week before finals was not an easy thing to do when the stress of finals hangs over you. I also had the challenge to swtich the "listview" container to a "recyleview" container in order to re-order the items in the list around. The things I had to learn in order to do this was making a item touch helper callback using interfaces that allows you to listen for “move” and “swipe” events. It’s also where you are able to control the state of the view selected, and override the default animations. Overall the challenges I faced where great and helped me think differently when building mobile apps as I develope mobile apps in React Native.

## License

    Copyright [2018] [Sparky Brown Evangelista]

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
    

