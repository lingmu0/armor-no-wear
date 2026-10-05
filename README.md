# Armor No Wear

服务端模组：玩家和生物穿戴的盔甲在受到伤害时不会损失耐久，护甲减伤效果保持原样。只需把对应 Minecraft 版本的 jar 放入服务端 `mods` 文件夹，客户端无需安装。

支持版本与加载器：

- Minecraft 1.20.1 + Forge
- Minecraft 1.21.1 + NeoForge

当前 Git 分支对应的版本：

- `mc-1.20.1`：Forge 1.20.1
- `mc-1.21.1`：NeoForge 1.21.1

构建当前分支：

```powershell
.\gradlew.bat build
```

输出 jar 位于 `build/libs/`。
