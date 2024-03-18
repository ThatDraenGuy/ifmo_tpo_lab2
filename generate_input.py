import numpy as np
import re
import pathlib

x = np.array(
    list(np.arange(-10, 10.5, 0.5)) +
    [ -4.435, -4.006, -3.892, -1.364 ] +
    [ -14.621, -8.412, -5.196, -2.129, -2.055 ] +
    [ -2* np.pi, -3 * np.pi /2, -np.pi, -np.pi /2, np.pi /2,  np.pi, 3 * np.pi /2, 2* np.pi ]
) 

def trig_func(x):
    sin = np.sin
    cos = np.cos
    csc = lambda x: 1 / np.sin(x)
    sec = lambda x: 1 / np.cos(x)
    tan = np.tan
    cot = lambda x: np.cos(x) / np.sin(x)

    return (((((((((((((((((sin(x) - csc(x)) + sec(x)) / sec(x)) - tan(x)) / (csc(x) / sec(x))) ** 2) + sin(x)) - (tan(x) ** 3)) / (sec(x) * cot(x))) + csc(x)) + ((cos(x) - ((cot(x) / cos(x)) ** 2)) + (csc(x) / ((cos(x) - cos(x)) + cos(x))))) ** 3) + (((tan(x) + (tan(x) ** 3)) / (csc(x) - (cos(x) * sec(x)))) - (cos(x) - sin(x)))) ** 2) / (((csc(x) * ((csc(x) + cos(x)) / sin(x))) * sec(x)) + (cos(x) - sin(x)))) * (((sin(x) / (sin(x) / cos(x))) / (((((sin(x) * tan(x)) ** 3) ** 3) / cot(x)) ** 2)) / (sin(x) / ((tan(x) ** 2) - (tan(x) * ((csc(x) ** 2) + ((sec(x) / ((sec(x) ** 2) - tan(x))) ** 2))))))) ** 2)

def log_func(x):
    log_3 = lambda x: np.log(x) / np.log(3)
    log_5 = lambda x: np.log(x) / np.log(5)
    log_10 = lambda x: np.log(x) / np.log(10)

    return (((((log_5(x) / log_3(x)) ** 3) + log_3(x)) ** 3) + log_10(x))

def app_func(x):
    y = np.where(x > 0, log_func(x), trig_func(x))
    return y

funcs = {
    "log": {
        "ln": np.log,
        "log3": lambda x: np.log(x) / np.log(3),
        "log5": lambda x: np.log(x) / np.log(5),
        "log10": lambda x: np.log(x) / np.log(10)
    },
    "trig": {
        "cos": np.cos,
        "cot": lambda x: np.cos(x) / np.sin(x),
        "sin": np.sin,
        "sec": lambda x: 1 / np.cos(x),
        "csc": lambda x: 1 / np.sin(x),
        "tan": np.tan
    },
    "app": {
        "log": log_func,
        "trig": trig_func,
        "app": app_func
    }
}

additional_vals = {
    "trig": {
        "tan": [
            -3 * np.pi / 2,
            -np.pi / 2,
            np.pi / 2,
            3 * np.pi / 2,
        ],
        "sec": [
            -3 * np.pi / 2,
            -np.pi / 2,
            np.pi / 2,
            3 * np.pi / 2,
        ],
        "cot": [
            -2 * np.pi,
            -np.pi,
            np.pi,
            2 * np.pi,
        ],
        "csc": [
            -2 * np.pi,
            -np.pi,
            np.pi,
            2 * np.pi,
        ],
        "trig": [
            -3 * np.pi / 2,
            -np.pi / 2,
            -2 * np.pi
            -np.pi,
            np.pi,
            2 * np.pi,
            np.pi / 2,
            3 * np.pi / 2,
        ],
        "app": [
            -3 * np.pi / 2
            -np.pi / 2,
            -2 * np.pi
            -np.pi,
        ]
    }
}

path_fills = [
    "src/test/resources/in",
    "src/test/resources/mock"
]
mock_path = "app/src/test/resources/mock"

for module in funcs:
    for func_name in funcs[module]:
        func = funcs[module][func_name]

        values = np.array([x, func(x)]).T
        values[:,1] = values[:,1].astype(object)
        values[np.isinf(values[:,1]),1] = np.nan
        for path_fill in path_fills:
            file_name = pathlib.Path(f"./{module}/{path_fill}/{func_name}.csv")
            file_name.parent.mkdir(exist_ok=True, parents=True)
            np.savetxt(file_name, values, delimiter=',\t')
            with open(file_name) as file:
                s = file.read().replace('nan', 'NaN')
                vals = additional_vals.get(module, {}).get(func_name, [])
                vals.sort()
                print(vals)
                for val in vals:
                    # pattern = re.escape(f'{val:.18e}') + '.*\n' if val >=0 else '\n(' + re.escape(f'{val:.18e}') + '.*\n)'
                    # s = re.sub(pattern, '', s)
                    # print(pattern)
                    if val >= 0:
                        s = re.sub('-?' + re.escape(f'{val:.18e}') + '.*\n', '', s)
                    else:
                        s = re.sub(re.escape(f'{val:.18e}') + '.*\n', '', s)
                    s += f'{val:.18e}, NaN\n'
            with open(file_name, 'w') as file:
                file.write(s)
            with open(f"./{mock_path}/{func_name}.csv", "w") as file:
                file.write(s)