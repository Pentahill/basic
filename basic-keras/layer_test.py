from keras.layers import Dense
from keras.models import Sequential
from keras.utils import np_utils
import numpy as np
import os
import cv2

label_dic = {"daisy": 0, "dandelion": 1, "roses": 2, "sunflowers": 3, "tulips": 4}


def load_dataset():

    images, labels = [], []

    def read_img(img_dir_path):
        for img_name in os.listdir(img_dir_path):
            img_abs_path = os.path.abspath(os.path.join(img_dir_path, img_name))
            if os.path.isdir(img_name):
                read_img(img_abs_path)
            else:
                img = cv2.imread(img_abs_path)
                img = cv2.cvtColor(img, cv2.COLOR_BGR2GRAY)
                img = cv2.resize(img, (224, 224))
                images.append(img.flatten())
                # 分类标签
                label = img_dir_path.split('\\')[-1]
                labels.append(label_dic[label])

    # ndarray
    path = 'D://tmp//flower_photos//train'
    for c in os.listdir(path):
        full_dir_path = os.path.abspath(os.path.join(path, c))
        read_img(full_dir_path)

    images = np.array(images)
    labels = np_utils.to_categorical(labels, 5)

    return images, labels


images, labels = load_dataset()
layer = Dense(32, input_dim=50176)
# config = layer.get_config()
# print(config)
# reconstructed_layer = Dense.from_config(config)
# print(layer.ouput_shape)
# print(layer.get_input_at(0))
# print(layer.get_output_at(0))
# print(layer.get_input_shape_at(0))
# print(layer.get_output_shape_at(0))

model = Sequential()
model.add(layer)
model.add(Dense(5))

# print(layer.input)
# print(layer.output)
# print(layer.input_shape)

model.build()
model.compile(loss='mean_squared_error', optimizer='sgd')
model.fit(images, labels)
