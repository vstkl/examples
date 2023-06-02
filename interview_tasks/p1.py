import re
import sys
import pytest

tests = [
    ("1s", 1),
    ("1m", 60),
    ("1h", 60*60),
    ("1d", 60*60*24),
    ("1.5m", 90),
    ("2a", KeyError),
    ("30seconds", KeyError),
    ("1 2", ValueError),
    ("a2", ValueError),
    ("6.6.6m", ValueError),

]

parse_input = lambda text: re.split('^([0-9]*\.?[0-d]*)(\w+)',text)[1:]


def parse(input_string):

    try:
        text = input_string
        parsed_data = parse_input(text)
        print(parsed_data)
        if len(parsed_data) < 1 or parsed_data[2] != '':
            raise ValueError("Invalid argument")
    except IndexError:
        raise ValueError("No arguments provided")

    try:

        time_value = float(parsed_data[0])
    except ValueError:
        raise ValueError("Time is not a number")

    try:
        time_unit = {
            's': 1,
            'm': 60,
            'h': 60 * 60,
            'd': 60 * 60 * 24,
            }[parsed_data[1]]
    except KeyError:
        raise KeyError("Invalid time unit")

    return int(time_value * time_unit)

def run_tests():

    print("\nRunning tests:")
    for unit in tests:
        # Testing expected errors
        if type(unit[1]) != type(1):
            with pytest.raises(unit[1]):
                parse(unit[0])
            print(f"Testing exception: {unit[0]} raises \t{unit[1].__name__}")
        else:
            print(f"Test: {unit[0]} equals  \t{unit[1]}")
            assert unit[1] == parse(unit[0])
       
if __name__ == "__main__":
    if len(sys.argv) > 1:
        for arg in sys.argv[1:]:
            # If one of arguments is "test", tests shall be run
            if arg == "test":
                run_tests()
                continue
            interval = parse(arg)
            print(f"User input: {arg} equals {interval}")

