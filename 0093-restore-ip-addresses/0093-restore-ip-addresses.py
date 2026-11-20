class Solution:
    def restoreIpAddresses(self, s: str) -> list[str]:
        result = []

        def backtrack(index, path):
            # If we have 4 segments
            if len(path) == 4:
                if index == len(s):
                    result.append(".".join(path))
                return

            # Try segments of length 1, 2, and 3
            for length in range(1, 4):

                # Avoid going beyond string length
                if index + length > len(s):
                    break

                segment = s[index:index + length]

                # Leading zero check
                if len(segment) > 1 and segment[0] == "0":
                    break

                # Value must be between 0 and 255
                if int(segment) > 255:
                    break

                # Choose
                path.append(segment)

                # Explore
                backtrack(index + length, path)

                # Undo choice
                path.pop()

        backtrack(0, [])
        return result