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

    The public surface of this class must be exactly `get`, `put`, and
    `add_eviction_listener`. All internal state (capacity, the dict,
    head/tail pointers, the listener list) must use a single leading
    underscore (`self._name`) — Python's convention for internal
    attributes.
    """

    def __init__(self, capacity):
        # TODO: validate capacity (raise ValueError on <= 0) and set up
        #       the internal dict + doubly linked list + listener list.
        pass

    def get(self, key):
        # TODO: return value if present (and mark MRU), else None.
        return None

    def put(self, key, value):
        # TODO: insert or update; if at capacity, evict the LRU entry
        #       (notifying eviction listeners) before inserting the new one.
        pass

    def add_eviction_listener(self, listener):
        # TODO: register a callable invoked as listener(key, value) each
        #       time an entry is evicted to make room (capacity eviction
        #       only — not when an existing key's value is updated).
        pass
