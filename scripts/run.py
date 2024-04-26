#!/usr/bin/env python3
"""
@author: Zsolt Kovari, Georg Hinkel

"""
import argparse
import os
import shutil
import subprocess
import sys
try:
    import ConfigParser
except ImportError:
    import configparser as ConfigParser
import json
from subprocess import CalledProcessError

BASE_DIRECTORY = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
print("Running benchmark with root directory " + BASE_DIRECTORY)

class JSONObject(object):
    def __init__(self, d):
        self.__dict__ = d


def build(conf, skip_tests=False):
    """
    Builds all solutions
    """
    for tool in conf.Tools:
        config = ConfigParser.ConfigParser()
        config.read(os.path.join(BASE_DIRECTORY, "solutions", tool, "solution.ini"))
        set_working_directory("solutions", tool)
        if skip_tests:
            subprocess.check_call(config.get('build', 'skipTests'), shell=True)
        else:
            subprocess.check_call(config.get('build', 'default'), shell=True)


def benchmark(conf):
    """
    Runs measurements
    """
    header = os.path.join(BASE_DIRECTORY, "output", "header.csv")
    result_file = os.path.join(BASE_DIRECTORY, "output", "output.csv")
    if os.path.exists(result_file):
        os.remove(result_file)
    shutil.copy(header, result_file)
    os.environ['Mutants'] = str(conf.Mutants)
    os.environ['Runs'] = str(conf.Runs)
    for r in range(0, conf.Runs):
        os.environ['RunIndex'] = str(r)
        for tool in conf.Tools:
            config = ConfigParser.ConfigParser()
            config.read(os.path.join(BASE_DIRECTORY, "solutions", tool, "solution.ini"))
            set_working_directory("solutions", tool)
            os.environ['Tool'] = tool
            for model in conf.Models:
                os.environ['SourcePath'] = os.path.abspath(os.path.join(BASE_DIRECTORY, 'models', model))
                for change_set in conf.ChangeSets:
                    os.environ['MutantSet'] = change_set
                    no_ext = os.path.splitext(model)[0]
                    for mutation in range(1, conf.Mutants + 1):
                        os.environ['Mutant'] = str(mutation)
                        os.environ['MutantPath'] = os.path.abspath(os.path.join(
                            BASE_DIRECTORY, 'models', no_ext,
                            no_ext + '-' + change_set + '-' + str(mutation),
                            'mutated.docbook'))
                        print("Running benchmark: tool = {}, mutant set = {}, mutant = {}".format(tool, change_set, mutation))
                        try:
                            output = subprocess.check_output(config.get('run', 'cmd'), shell=True, timeout=conf.Timeout)
                            with open(result_file, "ab") as file:
                                file.write(output)
                        except CalledProcessError as e:
                            print("Program exited with error")
                        except subprocess.TimeoutExpired as e:
                            print("Program reached the timeout set ({0} seconds). The command we executed was '{1}'".format(e.timeout, e.cmd))


def clean_dir(*path):
    dir = os.path.join(BASE_DIRECTORY, *path)
    if os.path.exists(dir):
        shutil.rmtree(dir)
    os.mkdir(dir)


def set_working_directory(*path):
    dir = os.path.join(BASE_DIRECTORY, *path)
    os.chdir(dir)


#def visualize():
 #   """
  #  Visualizes the benchmark results
   # """
    #clean_dir("diagrams")
    #set_working_directory("reporting")
    #subprocess.call(["Rscript", "visualize.R", os.path.join(BASE_DIRECTORY, "config", "reporting.json")])

def visualize():
    """
    Visualizes the benchmark results
    """
    clean_dir("diagrams")
    set_working_directory("diagrams")
    
    import numpy as np
    import pandas as pd
    import matplotlib.pyplot as plt
    import seaborn as sns
    
    data = pd.read_csv(os.path.join(BASE_DIRECTORY, 'output', 'output.csv'), sep=';')
    
    time_data = data[data['MetricName'] == 'Time']

    phases = time_data['PhaseName'].unique()
    sources = time_data['Source'].unique()

    colors = sns.color_palette('hsv', len(time_data['Tool'].unique()) // 2)

    batch_tools = time_data[time_data['Tool'].str.contains("Batch")]
    non_batch_tools = time_data[~time_data['Tool'].str.contains("Batch")]

    for source in sources:
        source_batch_data = batch_tools[batch_tools['Source'] == source]
        source_non_batch_data = non_batch_tools[non_batch_tools['Source'] == source]

        for phase in phases:
            batch_phase_data = source_batch_data[source_batch_data['PhaseName'] == phase]
            non_batch_phase_data = source_non_batch_data[source_non_batch_data['PhaseName'] == phase]

            plt.figure(figsize=(10, 6))
            sns.lineplot(data=batch_phase_data, x='Mutant', y='MetricValue', hue='Tool', palette=colors)
            plt.title(f'{source} - {phase} Phase Time Comparison (Batch Tools)')
            plt.ylabel('Time (ns)')
            plt.xlabel('Mutant')
            plt.legend(loc='lower center', bbox_to_anchor=(0.5, -0.3), ncol=5)
            plt.savefig(f'{source}_{phase}_batch_time_comparison.pdf', bbox_inches='tight')
            plt.close()

            plt.figure(figsize=(10, 6))
            sns.lineplot(data=non_batch_phase_data, x='Mutant', y='MetricValue', hue='Tool', palette=colors)
            plt.title(f'{source} - {phase} Phase Time Comparison (Non-Batch Tools)')
            plt.ylabel('Time (ns)')
            plt.xlabel('Mutant')
            plt.legend(loc='lower center', bbox_to_anchor=(0.5, -0.3), ncol=5)
            plt.savefig(f'{source}_{phase}_non_batch_time_comparison.pdf', bbox_inches='tight')
            plt.close()

    print("Diagrams successfully created and saved in 'diagrams' directory.")



def extract_results():
    """
    Extracts the benchmark results
    """
    clean_dir("results")
    set_working_directory("reporting")
    subprocess.call(["Rscript", "check_results.R"])


if __name__ == "__main__":
    parser = argparse.ArgumentParser()
    parser.add_argument("-b", "--build",
                        help="build the project",
                        action="store_true")
    parser.add_argument("-m", "--measure",
                        help="run the benchmark",
                        action="store_true")
    parser.add_argument("-s", "--skip-tests",
                        help="skip JUNIT tests",
                        action="store_true")
    parser.add_argument("-v", "--visualize",
                        help="create visualizations",
                        action="store_true")
    parser.add_argument("-e", "--extract",
                        help="extract results",
                        action="store_true")
    parser.add_argument("-t", "--test",
                        help="run test",
                        action="store_true")
    parser.add_argument("-d", "--debug",
                        help="set debug to true",
                        action="store_true")
    args = parser.parse_args()


    set_working_directory("config")
    with open("config.json", "r") as config_file:
        config = json.load(config_file, object_hook = JSONObject)

    if args.debug:
        os.environ['Debug'] = 'true'
    if args.build:
        build(config, args.skip_tests)
    if args.measure:
        benchmark(config)
    if args.test:
        build(config, False)
    if args.visualize:
        visualize()
    if args.extract:
        extract_results()

    # if there are no args, execute a full sequence
    # with the test and the visualization/reporting
    no_args = all(val==False for val in vars(args).values())
    if no_args:
        build(config, False)
        benchmark(config)
        visualize()
        extract_results()
