"""LRU Cache implementation (Assignment 7).

@author [Author Name]
(c) [YYYY]
"""


class Node:
    """Doubly linked list node holding a single key-value pair."""

    def __init__(self, key=None, value=None):
        # TODO: store key, value, and prev/next pointers.
        pass


class LRUCache:
    """Least Recently Used cache with O(1) get and put.

    The public surface of this class must be exactly `get` and `put`.
    All internal state (capacity, the dict, head/tail pointers) must
    be name-mangled with a double-underscore prefix (`self.__name`).
    """

    def __init__(self, capacity):
        # TODO: validate capacity (raise ValueError on <= 0) and set
        #       up the internal dict + doubly linked list.
        pass

    def get(self, key):
        # TODO: return value if present (and mark MRU), else None.
        return None

    def put(self, key, value):
        # TODO: insert or update; evict the LRU entry if at capacity.
        pass
