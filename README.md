Clock
A Java-based implementation of a 24-hour digital clock that tracks hours, minutes, and seconds. Developed as an assignment for TCSS 305 (Fall 2026).

Features
Time Tracking: Accurately maintains hours (0–23), minutes (0–59), and seconds (0–59).

Validation: Robust input validation that throws IllegalArgumentException for invalid time values or negative advance amounts.

Time Manipulation: Methods to advance the clock by specific hour and minute amounts with automatic roll-over handling.

Comparison & Equality: Implements Comparable<Clock> and overrides equals() and hashCode() for reliable sorting and equality checks.

String Representation: Formats time nicely via a custom toString() method.
