# ⚡ Lightning Blade ⚡
*Voice of the Thunderlord*



---

## 🌩️ **The Legend**

*In the realm where thunder echoes through eternity, there exists a blade forged not by mortal hands, but by the very essence of storm itself. The **Lightning Blade** - known to ancient texts as the "Voice of the Thunderlord" - was shaped in the heart of a celestial tempest, where lightning dances with divine purpose.*

*Legend speaks of Zeus himself breathing life into this weapon, binding the fury of a thousand storms within its steel. Each strike doesn't merely cut through flesh and bone - it channels the ancient voice of the Thunderlord, calling forth lightning from the heavens themselves.*

*Only those deemed worthy by destiny itself may wield this artifact of divine power. For in their hands, they hold not just a sword, but the very voice of thunder itself.*

---

## ⚔️ **Features**

### 🎯 **Divine Abilities**
- **Lightning Strike**: Right-click to summon Zeus's wrath upon your target
- **Cooldown Management**: Prevents spam with configurable cooldown system

### 🛠️ **Technical Excellence**
- **Custom Item System**: Persistent data containers for item identification
- **Adventure API Integration**: Modern text components with MiniMessage support
- **Configuration Management**: Fully customizable via YAML configuration
- **Imperat Framework**: Advanced command system with parameter validation
- **Event-Driven Architecture**: Efficient event handling for interactions

### 🎨 **Customization**
- **Material Selection**: Choose any sword material
- **Enchantment System**: Configurable enchantments with levels
- **Custom Lore**: Rich storytelling through item descriptions
- **Message Localization**: Customizable player messages
- **Range Control**: Adjustable lightning strike range

---

## 🏗️ **Architecture Overview**

### **Core Components**

```
📦 LightningBlade Plugin
├── 🏛️ LightningBlade.java          # Main plugin class & dependency injection
├── ⚙️ ConfigManager.java           # Configuration management & message system
├── 🗡️ BladeCustomItem.java         # Custom item builder & enchantment handler  
├── 💬 GiveCommand.java             # Command system with player targeting
└── ⚡ SwordUseEvent.java           # Event listeners & cooldown management
```

### **Design Patterns Used**
- **Singleton Pattern**: Plugin instance management
- **Builder Pattern**: Custom item construction
- **Observer Pattern**: Event-driven interactions
- **Strategy Pattern**: Configurable behavior system

---

## 🔧 **Technical Implementation**

### **Persistent Data Containers**
```java
NamespacedKey key = new NamespacedKey(plugin, "Lightning-Sword");
meta.getPersistentDataContainer().set(key, PersistentDataType.BOOLEAN, true);
```
Modern approach to item identification without relying on fragile NBT manipulation.

### **Adventure API Integration**
```java
private final MiniMessage mini = MiniMessage.miniMessage();
Component displayName = mini.deserialize(config.getString("Display-Name"));
```
Utilizes Paper's Adventure API for rich text formatting and future-proof text handling.

### **Dynamic Enchantment System**
```java
for (String enchantLine : enchantments) {
    String[] parts = enchantLine.split(":");
    Enchantment enchant = Enchantment.getByName(parts[0].toUpperCase());
    meta.addEnchant(enchant, Integer.parseInt(parts[1]), true);
}
```
Flexible enchantment application through configuration strings.

### **Efficient Cooldown Management**
```java
Map<UUID, Long> cooldownMap = new HashMap<>();
long timeLeft = ((lastUsed + cooldown) - System.currentTimeMillis()) / 1000;
```
UUID-based cooldown tracking with millisecond precision.

---

## 📋 **Installation & Usage**

### **Prerequisites**
- Minecraft Server 1.20+
- Paper/Spigot/Bukkit
- Java 17 or higher

### **Installation Steps**
1. Download the latest release from the releases page
2. Place `LightningBlade.jar` in your `plugins/` directory
3. Restart your server
4. Configure the plugin in `plugins/LightningBlade/config.yml`
5. Reload the plugin or restart the server

### **Commands**
```bash
/swords lightning [player]          # Give the Lightning Blade to a player
```

**Permissions:**
- `custom.swords` - Access to the swords command

---

## ⚙️ **Configuration**

```yaml
Lighting-Sword:
  Display-Name: "<blue>Voice of the <yellow>Thunderlord"
  Material: "IRON_SWORD"
  cooldown: 10 # seconds
  isEnchanted: true
  Enchantments:
    - "DAMAGE_ALL:5"
    - "FIRE_ASPECT:2"
  Range: 15 # blocks for air targeting
  Lore:
    - "<yellow>Forged in the <aqua>clouds <yellow>above the world"
    - "<gray>Shaped from the heart of a mighty storm"
    - "<blue>Each strike echoes the voice"
    - "<blue>of the ancient <yellow>Thunderlord"
    - "<dark_gray>Bound by storm, wielded by destiny"
    - "<italic><green>Right-click to summon the voice of <gold>Zeus</gold></green></italic>"

messages:
  cooldown: "you have to wait <red>%cooldown%</red> seconds before using %itemname%"
  playerGiveHimself: "<green>You have been blessed with <aqua>%item%</aqua>!"
  playerGaveAnother: "<green>You gave <aqua>%item%</aqua> to <blue>%player%</blue>!"
  playerReceivedFrom: "<green>You received <aqua>%item%</aqua> from <blue>%sender%</blue>!"
```

---

## 🎮 **How to Use**

1. **Obtain the Lightning Blade** using `/swords lightning`
2. **Right-click** while holding the blade to summon lightning
3. **Target blocks** by looking at them and right-clicking
4. **Target entities** by right-clicking directly on them
5. **Manage cooldown** - wait for the timer before next use

---

## 🤝 **Contributing**

This project serves as an educational resource. Feel free to:
- Study the code structure and patterns
- Suggest improvements or optimizations
- Report bugs or issues
- Create educational content based on this code

---

## 📄 **License**

This project is open source and available under the [MIT License](LICENSE).

---

## 👨‍💻 **Author**

**M7med** - *Plugin Developer & Storm Whisperer*

*"In code we trust, in lightning we strike."*

---

## ⚡ **May the Thunder Be With You** ⚡

*This plugin stands as a testament to the marriage of technical excellence and creative storytelling in Minecraft plugin development. Whether you're a server owner seeking divine weapons or a developer learning the craft, may this blade guide your path through the storms of code.*
