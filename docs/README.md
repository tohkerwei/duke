<!-- omit in toc -->
# Duke - A User Guide

- [1. Introduction](#1-introduction)
- [2. Quick Start](#2-quick-start)
- [3. Features](#3-features)
- [4. Usage](#4-usage)
  - [4.1. `todo` Command](#41-todo-command)
  - [4.2. `event` Command](#42-event-command)
  - [4.3. `deadline` Command](#43-deadline-command)
  - [4.4. `list` Command](#44-list-command)
  - [4.5. `done` Command](#45-done-command)
  - [4.6. `delete` Command](#46-delete-command)
  - [4.7. `find` Command](#47-find-command)
  - [4.8. `undo` Command](#48-undo-command)
  - [4.9. `bye` Command](#49-bye-command)

## 1. Introduction

Duke is a to do list. The 3 main things you can add into Duke are: tasks to be done, events and deadlines.

## 2. Quick Start

1. Ensure that you have Java 11 or above installed on your computer
2. Download the [latest release]
3. the duke release link
4. Enter the command `java -jar duke-0.2.0.jar` and the GUI should appear within a few seconds

## 3. Features

Here is a list of the available commands that this program understands:

1. `todo`
2. `event`
3. `deadline`
4. `list`
5. `done`
6. `delete`
7. `find`
8. `undo`

> Note that all commands should be in lower case.

## 4. Usage

To use Duke, type in the command that you want Duke to do, follow by details for the commands if required.

The detail formats are specified by the angle brackets. For example, `delete <index>` means that a number should follow behind delete, ie: `delete 2`

### 4.1. `todo` Command
**Description**
Adds a task to be done

**Format**
`todo <task>`

**Examples**

- `todo homework`
    - `homework` is added as a task to be done
    
- `todo watch webcast`
    -  `watch webcast` is added as a task to be done

### 4.2. `event` Command

**Description:**
Adds an event

**Format:**
`event <description> at <date><time>`
> `<date>` must be of the format `YYYY-MM-DD`
> `<time>` must be 24 hour and of the format `HH-MM`

**Examples**
- `event Runnus at 2020-12-12 12-00`
    - event `Runnus` at 12 Dec 2020 12:00 has been added
- `event Open House at 2020-02-02 12-12`
    - event `Open House` at 02 Feb 2020 12:00 has been added

### 4.3. `deadline` Command

**Description:**
Adds a deadline 

**Format:**
`deadline <description> by <date><time>`
- `<date>` must be of the format `YYYY-MM-DD`
- `<time>` must be 24 hour and of the format `HH-MM`

**Examples**

- `deadline Jar my Duke by 2020-12-12 12-00`
    - deadline `Jar my Duke` by 12 Dec 2020 12:00 has been added
    
- `deadline Get A for this by 2020-02-02 12-00`
    - deadline `Get A for this` by 02 Feb 2020 12:00 has been added

### 4.4. `list` Command

**Description:**
Lists all store tasks

**Format:**
`list`

### 4.5. `done` Command

**Description:**
Marks a task as done 

**Format:**
`done <index>`

- Index of task can be found using `list`

**Examples**

- `done 2`
    - the second task in the list will be marked and shown as done


- `done 5`
    - the fifth task in the list will be marked and shown as done


### 4.6. `delete` Command

**Description:**
Deletes a task

**Format:**
`delete <index>`

- Index of task can be found using `list`

**Examples**

- `delete 2`
    - the second task in the list will be deleted and shown as deleted


- `delete 5`
    - the fifth task in the list will be marked and shown as done


### 4.7. `find` Command

**Description:**
Find a task that contains the description

**Format:**
`find <description>`

- `<description>` is case-sensitive
- Tasks are searched and matched using the tasks description in the task list

**Examples**

- `find do`
  - all task with `do` as part of the description will be shown
- `find cs`
  - all task with `cs` as part of the description will be shown

### 4.8. `undo` Command

**Description**
Undo the last command

**Format**
`undo`

Examples
- `undo`
    - last command will be undone

### 4.9. `bye` Command

**Description**
Disallows input into the task list

**Format**
`bye`
