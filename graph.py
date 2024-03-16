import os, pathlib, csv
import matplotlib.pyplot as plt

out_dir_suffix = 'test/resources/out'
out_files_suffix = '.csv'

graph_out_dir_name = 'graphs'

graph_out_dir = pathlib.Path(graph_out_dir_name)
graph_out_dir.mkdir(parents=True, exist_ok=True)

for (dir_name, _, files) in os.walk("."):
    if (not dir_name.endswith(out_dir_suffix)): continue

    for file in files:
        if (not file.endswith(out_files_suffix)): continue

        func_name = file[0:-len(out_files_suffix)]

        values = {}

        with open(os.path.join(dir_name, file)) as csv_file:
            reader = csv.reader(csv_file)
            
            for (x, eps, y) in reader:
                if eps not in values:
                    values[eps] = {
                        'x': [],
                        'y': []
                    }

                values[eps]['x'].append(float(x))
                values[eps]['y'].append(float(y))

        plt.clf()

        plt.xlabel('x')
        plt.ylabel('y')
        plt.title(func_name)
        for eps in values:
            plt.plot(values[eps]['x'], values[eps]['y'], label=eps)
        plt.legend()
        plt.savefig(os.path.join(graph_out_dir, f'{func_name}.png'))
