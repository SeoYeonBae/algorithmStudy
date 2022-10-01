alpha = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']
world = input()

for a in alpha:
    world = world.replace(a, '*')

print(len(world))