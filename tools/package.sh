#!/usr/bin/env bash
# Builds an installable plugin zip without a JDK or Gradle.
# A theme plugin carries no compiled code, so the distribution is just the
# resources tree zipped into the layout the IDE expects:
#
#   Pax/lib/Pax.jar   (jar == zip of src/main/resources)
#
# Usage: ./tools/package.sh   ->  build/distributions/Pax-<version>.zip
set -euo pipefail

cd "$(dirname "$0")/.."

name="Pax"
version=$(sed -n 's/^pluginVersion *= *//p' gradle.properties)
staging="build/staging"
out="build/distributions"

rm -rf "$staging" "$out/$name-$version.zip"
mkdir -p "$staging/$name/lib" "$out"

(cd src/main/resources && zip -q -r -X "../../../$staging/$name/lib/$name.jar" .)
(cd "$staging" && zip -q -r -X "../../$out/$name-$version.zip" "$name")

rm -rf "$staging"
echo "$out/$name-$version.zip"
