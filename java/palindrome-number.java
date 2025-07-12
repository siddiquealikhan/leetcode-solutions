reverse = (reverse * 10) + (x % 10);
            x /= 10;
        }

        return reverse == xcopy;        
    }
}