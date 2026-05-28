"""Starter unit tests for the LRU cache (Assignment 7).

Run with `ant test` (or `python -m unittest discover -v`). These are
placeholder stubs — replace each body with real assertions that exercise
your implementation.

@author [Author Name]
(c) [YYYY]
"""

import unittest

from lru_cache import LRUCache


class TestLRUCache(unittest.TestCase):
    """Starter test suite for LRUCache; flesh out each test."""

    def setUp(self):
        self.cache = LRUCache(2)

    def test_get_missing_key_returns_none(self):
        # TODO: an unknown key returns None.
        pass

    def test_put_then_get_returns_value(self):
        # TODO: putting a key then getting it returns the stored value.
        pass

    def test_update_existing_key_is_not_eviction(self):
        # TODO: updating an existing key's value must not notify listeners.
        pass

    def test_capacity_eviction_removes_lru(self):
        # TODO: exceeding capacity evicts the least-recently-used entry.
        pass

    def test_invalid_capacity_raises_value_error(self):
        # TODO: constructing with capacity <= 0 raises ValueError.
        pass

    def test_eviction_listener_notified(self):
        # TODO: a registered listener is called with (key, value) on eviction.
        pass


if __name__ == "__main__":
    unittest.main()
