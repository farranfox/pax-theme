# Pax

A minimalist dark theme for JetBrains IDEs, rebuilt on top of the Islands UI
introduced in 2025.3.

## About

Pax is a dark theme built around a calm, low-contrast palette on a deep
blue-grey background.

It is developed on top of the [Carbon](https://github.com/luisfer0793/theme-carbon)
theme by **Luis Fernando Jiménez**. The original color palette is preserved;
everything else has been brought up to date. The theme inherits from
**Islands Dark**, so the editor and tool windows render as rounded islands,
the way JetBrains IDEs look by default since 2025.3.

- Islands UI out of the box — no extra plugin, no setting to flip
- **JetBrains Mono** as the default editor and console font
- No italics anywhere in the syntax highlighting

Requires **2025.3 (build 253) or newer**.

## Install

`Settings | Plugins | ⚙ | Install Plugin from Disk…`, pick the zip, restart
the IDE, then choose **Pax** in
`Settings | Appearance & Behavior | Appearance | Theme`.

## Build

```bash
gradle buildPlugin        # -> build/distributions/pax-theme-<version>.zip
gradle runIde             # sandbox IDE with the theme installed
```

A theme is pure resources, so the zip can also be assembled without a JDK:

```bash
./tools/package.sh
```

## Credits

Pax is based on the [Carbon](https://github.com/luisfer0793/theme-carbon) theme
by [Luis Fernando Jiménez](https://github.com/luisfer0793). The original color
palette and syntax scheme are used with gratitude.

## License

[MIT](LICENSE) © Farukh Narzullaev
