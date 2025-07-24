# ⚡ LightningBlade Plugin

**LightningBlade** is a simple and configurable Minecraft plugin that grants players a divine sword capable of summoning lightning upon right-clicking blocks or entities. With built-in support for cooldowns, enchantments, and customizable messages, this plugin provides an epic experience for players and server admins alike.

---

## ✨ Features

- ⚡ **Custom Lightning Sword**
  - Summon lightning on right-click (block or entity)
  - Apply configurable enchantments
  - Unique name, lore, and item metadata

- ⏱️ **Cooldown System**
  - Prevents spamming with customizable delay per player

- ⚙️ **Fully Configurable**
  - Material, name, lore, range, enchantments, cooldown, and messages from `config.yml`

- 🧠 **Imperat Command System**
  - Uses the [Imperat](https://github.com/VelixMC/imperat) framework for clean, annotation-based command handling
  - Built-in argument suggestions, permission checks, and console support

- 🔐 **Permission-Based Access**
  - Only authorized users (`custom.swords`) can issue sword commands

---

## 🧾 Command Usage

```plaintext
/swords lightning [player]
