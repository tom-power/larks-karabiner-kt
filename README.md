### larky [Karabiner elements](https://github.com/tekezo/Karabiner-Elements) bindings for MacOS.

```shell
clone https://github.com/tom-power/larks-karabiner-kt.git &&
cd larks-karabiner-kt &&
./gradlew build &&
cp ./app/build/*.json ~/.config/karabiner/assets/complex_modifications/
```

The rules will need to be loaded in the Karabiner elements UI:

```"Preferences" -> "Complex Modifications" -> "Add rule" -> "larks ..." -> "Enable all"```
