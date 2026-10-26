# Apple Leaves for Better than Adventure!

A port of morgana's [b1.7.3 Babric Apple Leaves](https://github.com/morgana-x/babric-apples) to
**Better than Adventure! 8.0.1** (Babric) using **HalpLibe 6.2.0**.

Oak leaves have a 1 in 200 chance of dropping an apple when they decay or are broken without shears.
When the apple drops it replaces the normal drop (sapling or nothing), the same as the original mod.
Only oak leaves are affected. Works on servers and in singleplayer; clients joining a server don't need it.

## Config

`config/appleleaves.cfg` is created on first launch:

```toml
[Drops]
# Oak leaves drop an apple 1 in this many times ... Set to 0 to disable.
appleChance = 200
```

## What changed from the Beta version

| Beta 1.7.3 (Babric + BINY) | BTA 8.0.1 (Babric + HalpLibe) |
| --- | --- |
| `LeavesBlockMixin` overrides `dropStacks` | `BlockLogicLeavesBaseMixin` injects at the return of `getBreakResult` |
| Oak picked out by metadata `(meta & 1) == 0` | Oak is its own block, `Blocks.LEAVES_OAK` |
| `Item.APPLE` / `world.random` / `world.isRemote` | `Items.FOOD_APPLE` / `world.rand` / `world.isClientSide` |
| Shears never reach `dropStacks` | Silk touch, shears and pick-block drops are left alone explicitly |
| Fixed 1/200 chance | 1/200 by default, configurable through HalpLibe's TOML config |
| Groovy Gradle, fabric-loom + babric-loom-extension | Kotlin Gradle from Turnip Labs' `bta-example-mod` (8.0 branch), Java 17 target |

## Building

You need a JDK 21 (Gradle itself runs on 21; the mod is compiled for Java 17).

```sh
./gradlew build
```

The jar ends up in `build/libs/`. Drop it in your BTA 8.0.1 `mods` folder together with HalpLibe 6.2.0.

`./gradlew runClient` starts a dev client with the mod loaded.

## License

MIT, same as the original.
