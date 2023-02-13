import pytest
import time
from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.by import By


driver = webdriver.Firefox()


def test_create_driver():
    driver.get("https://www.amazon.in/")
    driver.maximize_window()
    print(f"website ({driver.title}) is opened successfully through {driver}")


def test_signin():
    signin=driver.find_element(By.XPATH,"//span[@id='nav-link-accountList-nav-line-1']")
    signin.click()
    driver.implicitly_wait(5)           #for loading 
    phone_number=driver.find_element(By.XPATH,"//input[@id='ap_email']")
    phone_number.send_keys("9032274756")
    phone_number.send_keys(Keys.RETURN)
    driver.implicitly_wait(5)
    password=driver.find_element(By.XPATH,"//input[@id='ap_password']")
    password.send_keys("satya123")
    password.send_keys(Keys.RETURN)
    driver.implicitly_wait(15)
    print("sign-in is completed")


def test_keys_to_search_box():
    search=driver.find_element(By.ID, "twotabsearchtextbox")
    search.send_keys("mobiles")
    time.sleep(3)                        
    search.send_keys(Keys.RETURN)
    print("Keys are sent to search box")


def test_select_product():
    brand=driver.find_element(By.XPATH,"//li[@id='p_89/Oppo']//div[@class='a-checkbox a-checkbox-fancy s-navigation-checkbox aok-float-left']")
    time.sleep(3)
    brand.click()
    c_window=driver.current_window_handle     #to switch the tabs
    item=driver.find_element(By.XPATH,"//div[@class='s-widget-container s-spacing-small s-widget-container-height-small celwidget slot=MAIN template=SEARCH_RESULTS widgetId=search-results_1']//div[@class='a-section a-spacing-none puis-padding-right-small s-title-instructions-style']//span[1]")
    item.click()
    print("product was selected")


def test_add_to_cart():
    handles=[]
    handles=driver.window_handles
    f_window=handles[1]
    driver.switch_to.window(f_window)
    add_cart=driver.find_element(By.XPATH,"//input[@id='add-to-cart-button']")
    add_cart.click()
    time.sleep(3)
    driver.switch_to.window(handles[0])
    open_cart=driver.find_element(By.XPATH,"//span[normalize-space()='Cart']")
    open_cart.click()
    time.sleep(3)
    print("product was added to cart")


def test_tear_driver():
    driver.quit()
    print("successfully closed the driver!!!")


