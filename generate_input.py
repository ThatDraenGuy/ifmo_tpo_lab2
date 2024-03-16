import numpy as np

x = np.arange(-10, 10.5, 0.5)

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
    }
}

path_fill = "src/test/resources/in"
mock_path = "app/src/test/resources/mock"

for module in funcs:
    for func_name in funcs[module]:
        func = funcs[module][func_name]

        values = np.array([x, func(x)]).T
        values[:,1] = values[:,1].astype(object)
        values[np.isinf(values[:,1]),1] = np.nan
        file_name = f"./{module}/{path_fill}/{func_name}.csv"
        np.savetxt(file_name, values, delimiter=',\t')
        with open(file_name) as file:
            s = file.read().replace('nan', 'NaN')
        with open(file_name, 'w') as file:
            file.write(s)
        with open(f"./{mock_path}/{func_name}.csv", "w") as file:
            file.write(s)