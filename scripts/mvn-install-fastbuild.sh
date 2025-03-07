#!/bin/bash
#
# Copyright 2022, Gerwin Klein, Régis Décamps, Steven Rowe
# SPDX-License-Identifier: BSD-3-Clause
#

EXTRA_PROJECTS=$1

BASEDIR="$(cd "$(dirname "$0")" && pwd -P)"/..
# Provides the logi function
source "$BASEDIR"/scripts/logger.sh
MVN="$BASEDIR"/mvnw

QUIET=""
if [[ "$TRAVIS" ]]; then
  # Quiet mode shows errors only.
  QUIET="--quiet"
fi

# TODO(regisd) Define the list of packages via the profile
logi "Build and install JFlex only (-P fastbuild)"
cd "$BASEDIR"
"$MVN" ${QUIET} -Pfastbuild -pl .,cup-maven-plugin,jflex install

if [[ -n "$EXTRA_PROJECTS" ]]; then
  "$MVN" ${QUIET} -Pfastbuild -pl "$EXTRA_PROJECTS" install
fi

cd "$CWD"

