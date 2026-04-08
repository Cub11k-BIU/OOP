# Assignment 7

## [Assignment Wiki page](../../wiki/Assignment-7)

A Least Recently Used (LRU) Cache in Python with O(1) `get` and `put`.
Combine a `dict` for O(1) key lookup with a custom doubly linked list
for O(1) recency updates. See the wiki page above for the full spec.

## Files

| File | Purpose |
|---|---|
| `lru_cache.py` | Your `Node` and `LRUCache` implementation. |
| `main.py` | Your demonstration script — exercises and proves the four required behaviors. |
| `build.xml` | Ant wrapper around the Python interpreter. |

## Usage

```sh
ant run     # runs main.py
ant test    # runs `python -m unittest discover` (picks up any test_*.py)
ant clean   # removes Python bytecode caches
```

The build defaults to `py` as the interpreter (Windows). On Linux/macOS:

```sh
ant -Dapp.python.exec=python3 run
```
