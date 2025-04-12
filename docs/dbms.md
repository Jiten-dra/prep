# 📚 Summary: RDBMS vs NoSQL, Data Locality, Storage, and LSM Trees

---

## 🔹 RDBMS vs NoSQL: Locality & Performance

| Concept                         | Description                                                                 |
|----------------------------------|-----------------------------------------------------------------------------|
| **Data Locality**                | Co-located data stored close together physically (disk/page) = faster access |
| **RDBMS Random Access**          | Uses **indexes + fixed page size** to directly jump to data                 |
| **NoSQL Access Pattern**         | Often optimized for sequential reads/writes, not random access              |
| **Why NoSQL is fast?**           | Due to **locality, append-only writes, no joins**, denormalization          |
| **When RDBMS is better?**        | When updates are frequent, schema is fixed, and joins/transactions are needed |

---

## 🔹 Denormalization & Data Locality Validity

| When It's Valid                              | When It’s Not Valid                             |
|----------------------------------------------|--------------------------------------------------|
| When data is split across multiple tables     | When data already exists in one table or record |
| To reduce joins and improve read latency      | If no joins exist, it doesn’t improve much      |

---

## 🔹 Storage & Updates

| Concept                        | RDBMS                                       | NoSQL (e.g., Document DB)                         |
|-------------------------------|---------------------------------------------|--------------------------------------------------|
| **Storage Efficiency**         | Allocates only required size (InnoDB)       | May store full documents, can increase overhead  |
| **Update Behavior**            | In-place updates (unless row grows too big) | May involve rewriting entire document            |
| **Page Concept**               | Yes (InnoDB uses 16KB pages)                | Yes (most engines like RocksDB also use pages)   |

---

## 🔹 LSM Tree Summary (Log-Structured Merge Tree)

| Level | Description                                                                |
|-------|----------------------------------------------------------------------------|
| **MemTable** | In-memory sorted structure for fast writes                             |
| **Level 0**  | Recently flushed data; multiple files with **overlapping ranges**      |
| **Level 1**  | Sorted, **non-overlapping** SSTables                                   |
| **Level 2+** | Larger merged files; more optimized for space, less read amplification |

---

### 🔁 Insert Flow Example (Simplified)

1. Inserted into MemTable
2. MemTable flushed → SSTable in Level 0
3. If Level 0 is full → compact into Level 1
4. If Level 1 full → compact to Level 2
5. Each level gets **bigger**, more compact, fewer files

---

## 🔍 Read Behavior Summary

| Read Target | Action                                            |
|-------------|---------------------------------------------------|
| **MemTable** | Check first — fast memory lookup                 |
| **Level 0**  | Check all overlapping files                      |
| **Level 1+** | Sorted SSTables, binary search + bloom filters   |

---

### 📘 Read Examples

| Key Read | Level Hit     | Reason                                |
|----------|---------------|----------------------------------------|
| `4`      | Level 0       | Recently inserted, not yet compacted   |
| `13`     | Level 2       | Older data, compacted into deeper level |
| `30`     | Level 0       | Recently inserted                      |

---
